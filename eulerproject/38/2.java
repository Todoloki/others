import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i <= K; i++) {
            numbers.add(i);
        }
        
        List<Long> permutations = new ArrayList<Long>();
        HashSet<Integer> multipliers = new HashSet<Integer>();
        
        getAllPermutations(numbers, new boolean[numbers.size()], permutations, 0, 0);
        for (int i = 0; i < permutations.size(); i++) {
            // System.out.println(permutations.get(i));
            collectMultipliers(permutations.get(i), multipliers, N);
        }
        List<Integer> muls = new ArrayList<Integer>();
        for (int i : multipliers) {
            muls.add(i);
        }
        Collections.sort(muls);
        for (int i = 0; i < muls.size(); i++) {
            if (muls.get(i) == 1) {
                continue;
            }
            System.out.println(muls.get(i));
        }
        scanner.close();
    }
    public static void getAllPermutations(List<Integer> numbers, boolean[] visited, List<Long> permutations, long curNumber, int curLength) {
        if (curLength == numbers.size()) {
            permutations.add(curNumber);
            return ;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                getAllPermutations(numbers, visited, permutations, curNumber * 10 + numbers.get(i), curLength + 1);
                visited[i] = false;
            }
        }
    }
    public static void collectMultipliers(long number, HashSet<Integer> set, int limit) {
        String s = "" + number;
        for (int l = 1; l <= 4; l++) {
            String num = s.substring(0, l);
            int start = l;
            int n = Integer.parseInt(num);
            if (n >= limit) {
                break;
            }
            int sum = n + n;
            while (start < s.length()) {
                String next = "" + sum;
                if (start + next.length() > s.length()) {
                    break;
                }
                String nextConcat = s.substring(start, start + next.length());
                if (nextConcat.equals(next)) {
                    start += next.length();
                    sum += n;
                }
                else {
                    break;
                }
                if (start == s.length()) {
                    set.add(n);
                }
            }
        }
    }
}
// passed hackerrank
