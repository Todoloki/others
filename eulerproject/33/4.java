import java.io.*;
import java.util.*;

public class Solution {
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
        
        for (int i = 0; i < remain; i++) {
            base *= 10;
        }
        // System.out.println(base);
        List<Integer> cancelledList = new ArrayList<Integer>();
        if (K == 1) {
            for (int i = 1; i <= 9; i++) {
                cancelledList.add(i);
            }
        }
        else if (K == 2) {
            for (int i = 1; i <= 9; i++) {
                for (int j = i; j <= 9; j++) {
                    cancelledList.add(i * 10 + j);
                }
            }
        }
        else {
            for (int i = 1; i <= 9; i++) {
                for (int j = i; j <= 9; j++) {
                    for (int k = j; k <= 9; k++) {
                        cancelledList.add(i * 100 + j * 10 + k);
                    }
                }
            }
        }
        long sumOfNumerators = 0;
        long sumOfDenominators = 0;
        HashMap<Integer, HashSet<Integer>> set = new HashMap<Integer, HashSet<Integer>>();
        for (int cancelled : cancelledList) {
            // System.out.println(cancelled);
            List<Pair> pairList = new ArrayList<Pair>();
            List<Integer> permutations = getPermutations(cancelled);
            // for (int permutation : permutations) {
                // System.out.println(permutation);
            // }
            for (int number = 0; number < base; number++) {
                List<Integer> originals = getOriginals(permutations, number, N - K, N);
                // System.out.println(number + " " + cancelled);
                for (int original : originals) {
                    // System.out.println(original);
                    pairList.add(new Pair(number, original));
                }
            }
            Collections.sort(pairList, new Comparator<Pair>() {
                @Override
                public int compare(Pair p1, Pair p2) {
                    return p1.cancelled - p2.cancelled;
                }
            });
            for (int i = 0; i < pairList.size(); i++) {
                for (int j = i + 1; j < pairList.size(); j++) {
                    Pair p1 = pairList.get(i);
                    Pair p2 = pairList.get(j);
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
                        if (set.containsKey(p1.original) == false) {
                            HashSet<Integer> s1 = new HashSet<Integer>();
                            s1.add(p2.original);
                            set.put(p1.original, s1);
                            sumOfNumerators += p1.original;
                            sumOfDenominators += p2.original;
                        }
                        else {
                            if (set.get(p1.original).contains(p2.original) == false) {
                                sumOfNumerators += p1.original;
                                sumOfDenominators += p2.original;
                                set.get(p1.original).add(p2.original);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(sumOfNumerators + " " + sumOfDenominators);
    }
    public static List<Integer> getPermutations(int cancelled) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> numbers = new ArrayList<Integer>();
        while (cancelled != 0) {
            numbers.add(cancelled % 10);
            cancelled /= 10;
        }
        boolean[] visited = new boolean[numbers.size()];
        generatePermutations(list, numbers, visited, 0, 0);
        return list;
    }
    public static void generatePermutations(List<Integer> list, List<Integer> numbers, boolean[] visited, int curNumber, int curLength) {
        if (curLength == numbers.size()) {
            list.add(curNumber);
            return ;
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (visited[i] == false) {
                visited[i] = true;
                generatePermutations(list, numbers, visited, curNumber * 10 + numbers.get(i), curLength + 1);
                visited[i] = false;
            }
        }
    }
    public static List<Integer> generatePermutations(int number) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> numbers = new ArrayList<Integer>();
        while (number != 0) {
            numbers.add(number % 10);
            number /= 10;
        }
        generatePermutations(list, numbers, new boolean[numbers.size()], 0, 0);
        return list;
    }

    public static List<Integer> getOriginals(List<Integer> permutations, int cancelled, int remain, int N) {
        List<Integer> list = new ArrayList<Integer>();
        for (int permutation : permutations) {
            getOriginal(permutation, cancelled, list, remain, 0, N);
        }
        return list;
    }
    public static void getOriginal(int permutation, int cancelled, List<Integer> list, int remain, int curNumber, int N) {
        if (permutation == 0 && remain == 0) {
            if (curNumber % 10 == 0) {
                return ;
            }
            String s = "" + curNumber;
            while (s.length() < N) {
                s = "0" + s;
            }
            list.add(Integer.parseInt(new StringBuffer(s).reverse().toString()));
            return ;
        }
        if (permutation != 0) {
            getOriginal(permutation / 10, cancelled, list, remain, curNumber * 10 + permutation % 10, N);
        }
        if (remain != 0) {
            getOriginal(permutation, cancelled / 10, list, remain - 1, curNumber * 10 + cancelled % 10, N);
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
}
// I can not optimize it anymore
// seems https://github.com/yuechi/projecteuler have a good solution
// I will see this solution first, understand and then get the answer.
