import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        
        List<Long> permutations = getAllPermutations(N);
        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        primes.add(11);
        primes.add(13);
        primes.add(17);
        long sum = 0;
        for (long permutation : permutations) {
            long lessThan = 1;
            for (int i = 0; i < N; i++) {
                lessThan *= 10;
            }
            long moreThan = lessThan / 1000;
            int index = 0;
            boolean valid = true;
            while (moreThan != 0) {
                long curNumber = permutation % lessThan;
                curNumber /= moreThan;
                if (curNumber % primes.get(index) != 0) {
                    valid = false;
                    break;
                }
                lessThan /= 10;
                moreThan /= 10;
                index++;
            }
            if (valid) {
                sum += permutation;
            }
        }
        System.out.println(sum);
        scanner.close();
    }
    public static List<Long> getAllPermutations(int N) {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i <= N; i++) {
            numbers.add(i);
        }
        List<Long> permutations = new ArrayList<Long>();
        collectPermutations(numbers, new boolean[numbers.size()], permutations, 0, 0);
        return permutations;
    }
    public static void collectPermutations(List<Integer> numbers, boolean[] visited, List<Long> list, long curNumber, int curLength) {
        if (curLength == numbers.size()) {
            list.add(curNumber);
            return ;
        }
        for (int i = 0; i < numbers.size(); i++) {
            /*
            if (curLength == 0 && i == 0) {
                continue;
            }
            */
            if (visited[i] == false) {
                visited[i] = true;
                collectPermutations(numbers, visited, list, curNumber * 10 + numbers.get(i), curLength + 1);
                visited[i] = false;
            }
        }
    }
}
// passed hackerrank
// numbers start with 0 also are included in this solution.
