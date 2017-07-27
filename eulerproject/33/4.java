import java.util.*;
import java.math.*;
import java.io.*;

public class Mysample {
    public static class Pair {
        int cancelled;
        int original;
        Pair (int cancelled, int original) {
            this.cancelled = cancelled;
            this.original = original;
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int remain = N - K;

        int base = 1;
        int temp = remain;
        for (int i = 0; i < remain; i++) {
            base *= 10;
        }
        List<String> cancelledList = new ArrayList<String>();
        if (K == 1) {
            for (int i = 1; i <= 9; i++) {
                cancelledList.add("" + i);
            }
        }
        else if (K == 2) {
            for (int i = 1; i <= 9; i++) {
                for (int j = i; j <= 9; j++) {
                    cancelledList.add("" + i + j);
                }
            }
        }
        else {
            for (int i = 1; i <= 9; i++) {
                for (int j = i; j <= 9; j++) {
                    for (int k = j; k <= 9; k++) {
                        cancelledList.add("" + i + j + k);
                    }
                }
            }
        }

        // HashSet<Integer> numerators = new HashSet<Integer>();
        // HashSet<Integer> denominators = new HashSet<Integer>();
        HashSet<String> set = new HashSet<String>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String cancelledNumber : cancelledList) {
            // System.out.println(cancelledNumber);
            List<String> permutations = getPermutations(cancelledNumber);
            List<Pair> pairList = new ArrayList<Pair>();
            for (int i = 0; i < base; i++) {
                String t = "" + i;
                while (t.length() < remain) {
                    t = "0" + t;
                }
                getPairs(permutations, t, pairList);
            }

            for (Pair pp : pairList) {
                String key = pp.cancelled + " " + pp.original;
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                }
                else {
                    map.put(key, 1);
                }
                // System.out.println(pp.cancelled + " " + pp.original);
            }
            Collections.sort(pairList, new Comparator<Pair>() {
                @Override
                public int compare(Pair p1, Pair p2) {
                    return p1.cancelled - p2.cancelled;
                }
            });

            for (int j = 0; j < pairList.size(); j++) {
                for (int k = j + 1; k < pairList.size(); k++) {

                    Pair p1 = pairList.get(j);
                    Pair p2 = pairList.get(k);
                    // System.out.println(p1.original + " " + p2.original + " " + p1.cancelled + " " + p2.cancelled);
                    if (p1.original >= p2.original) {
                        continue;
                    }
                    int gcd = getGCD(p1.original, p2.original);
                    int o1 = p1.original / gcd;
                    int o2 = p2.original / gcd;
                    gcd = getGCD(p1.cancelled, p2.cancelled);
                    int c1 = p1.cancelled / gcd;
                    int c2 = p2.cancelled / gcd;
                    if (c1 == o1 && c2 == o2) {
                        // System.out.println(p1.original + " " + p1.cancelled + " " + p2.original + " " + p2.cancelled);
                        // numerators.add(p1.original);
                        // denominators.add(p2.original);
                        String key = p1.original + " " + p2.original;
                        set.add(key);
                    }
                }
            }

        }
        long sumOfNumerators = 0;
        long sumOfDenominators = 0;
        for (String ss : set) {
            String[] nums = ss.split("\\s+");
            sumOfNumerators += Integer.parseInt(nums[0]);
            sumOfDenominators += Integer.parseInt(nums[1]);
        }
        System.out.println(sumOfNumerators + " " + sumOfDenominators);
        for (String ss : map.keySet()) {
            if (map.get(ss) > 1)
            System.out.println(ss + " " + map.get(ss));
        }
    }
    public static int getGCD(int a, int b) {
        if (a <= 1 || b <= 1) {
            return 1;
        }
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (a % b == 0) {
            return b;
        }
        return getGCD(b, a % b);
    }
    public static List<String> getPermutations(String s) {
        List<String> list = new ArrayList<String>();
        boolean[] visited = new boolean[s.length()];
        generatePermutations(list, s, visited, 0, "");
        return list;
    }
    public static void generatePermutations(List<String> list, String s, boolean[] visited, int length, String curStr) {
        if (length == s.length()) {
            list.add(curStr);
            return ;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                generatePermutations(list, s, visited, length + 1, curStr + s.charAt(i));
                visited[i] = false;
            }
        }
    }
    public static void getPairs(List<String> permutations, String cancelled, List<Pair> pairList) {
        for (String s : permutations) {
            List<String> list = twist(s, cancelled);
            for (String twisted : list) {
                if (twisted.charAt(0) == '0') {
                    continue;
                }
                pairList.add(new Pair(Integer.parseInt(cancelled), Integer.parseInt(twisted)));
            }
        }
    }
    public static List<String> twist(String s1, String s2) {
        List<String> list = new ArrayList<String>();
        generateTwistedList(list, s1, s2, 0, 0, "");
        return list;
    }
    public static void generateTwistedList(List<String> list, String s1, String s2, int index1, int index2, String currentStr) {
        if (index1 == s1.length() && index2 == s2.length()) {
            list.add(currentStr);
            return ;
        }
        if (index1 < s1.length()) {
            generateTwistedList(list, s1, s2, index1 + 1, index2, currentStr + s1.charAt(index1));
        }
        if (index2 < s2.length()) {
            generateTwistedList(list, s1, s2, index1, index2 + 1, currentStr + s2.charAt(index2));
        }
    }
}
// hackerrank still can not pass case 4
