import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        
        boolean[] isNotPrime = new boolean[(N * 10 - 1) / 2 + 1];
        
        HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        
        for (int i = 1; i < isNotPrime.length; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            int nextIndex = 2 * i + 1;
            addToMap(nextIndex, map);
            long next = nextIndex;
            next = next * next - 1;
            next /= 2;
            if (next >= isNotPrime.length) {
                continue;
            }
            for (int j = ((2 * i + 1) * (2 * i + 1) - 1) / 2; j < isNotPrime.length; j += 2 * i + 1) {
                isNotPrime[j] = true;
            }
        }
        List<int[]> res = new ArrayList<int[]>();
        if (K == 3) {
            for (String s : map.keySet()) {
                if (map.get(s).size() < 3) {
                    continue;
                }
                List<Integer> list = map.get(s);
                for (int i1 = 0; i1 < list.size() - 2; i1++) {
                    if (list.get(i1) >= N) {
                        break;
                    }
                    for (int i2 = i1 + 1; i2 < list.size() - 1; i2++) {
                        for (int i3 = i2 + 1; i3 < list.size(); i3++) {
                            int diff1 = list.get(i2) - list.get(i1);
                            int diff2 = list.get(i3) - list.get(i2);
                            if (diff1 == diff2) {
                                //System.out.println("" + list.get(i1) + list.get(i2) + list.get(i3));
                                res.add(new int[]{list.get(i1), list.get(i2), list.get(i3)});
                            }
                        }
                    }
                }
            }
        }
        else {
            for (String s : map.keySet()) {
                if (map.get(s).size() < 4) {
                    continue;
                }
                List<Integer> list = map.get(s);
                for (int i1 = 0; i1 < list.size() - 3; i1++) {
                    if (list.get(i1) >= N) {
                        break;
                    }
                    for (int i2 = i1 + 1; i2 < list.size() - 2; i2++) {
                        int diff1 = list.get(i2) - list.get(i1);
                        for (int i3 = i2 + 1; i3 < list.size() - 1; i3++) {
                            int diff2 = list.get(i3) - list.get(i2);
                            if (diff1 != diff2) {
                                continue;
                            }
                            for (int i4 = i3 + 1; i4 < list.size(); i4++) {
                                int diff3 = list.get(i4) - list.get(i3);
                                if (diff2 == diff3) {
                                    // System.out.println("" + list.get(i1) + list.get(i2) + list.get(i3) + list.get(i4));
                                    res.add(new int[]{list.get(i1), list.get(i2), list.get(i3), list.get(i4)});
                                }
                            }
                        }
                    }
                }
            }
        }
        Collections.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[0] - p2[0];
            }
        });
        for (int[] pair : res) {
            for (int i = 0; i < pair.length; i++) {
                System.out.print(pair[i]);
            }
            System.out.println("");
        }
    }
    public static void addToMap(int number, HashMap<String, List<Integer>> map) {
        List<Integer> numbers = new ArrayList<Integer>();
        int temp = number;
        while (temp != 0) {
            numbers.add(temp % 10);
            temp /= 10;
        }
        Collections.sort(numbers);
        String key = "";
        for (int i = 0; i < numbers.size(); i++) {
            key = key + numbers.get(i);
            
        }
        if (map.containsKey(key)) {
            map.get(key).add(number);
        }
        else {
            List<Integer> list = new ArrayList<Integer>();
            list.add(number);
            map.put(key, list);
        }
    }
}
// passed hackerrank
