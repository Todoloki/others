import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        int numOfDigits = 7;
        List<Integer> pandigitalPrime = new ArrayList<Integer>();
        
        while (numOfDigits > 1) {
            List<Integer> permutations = getPermutations(numOfDigits);
            for (int permutation : permutations) {
                if (isPrime(permutation)) {
                    pandigitalPrime.add(permutation);
                }
            }
            numOfDigits--;
        }
        Collections.sort(pandigitalPrime);
        
        for (int i = 0; i < numOfCases; i++) {
            long max = scanner.nextLong();
            int left = 0;
            int right = pandigitalPrime.size() - 1;
            while (left + 1 < right) {
                int mid = (left + right) / 2;
                if (pandigitalPrime.get(mid) > max) {
                    right = mid;
                }
                else {
                    left = mid;
                }
            }
            if (pandigitalPrime.get(right) <= max) {
                System.out.println(pandigitalPrime.get(right));
                continue ;
            }
            if (pandigitalPrime.get(left) <= max) {
                System.out.println(pandigitalPrime.get(left));
                continue ;
            }
            System.out.println(-1);
        }
    }
    public static boolean isPrime(int num) {
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        int factor = 6;
        while (factor - 1 <= (int) Math.floor(Math.sqrt(num))) {
            if (num % (factor - 1) == 0) {
                return false;
            }
            if (num % (factor + 1) == 0) {
                return false;
            }
            factor += 6;
        }
        return true;
    }
    public static List<Integer> getPermutations(int numOfDigits) {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i <= numOfDigits; i++) {
            numbers.add(i);
        }
        List<Integer> permutations = new ArrayList<Integer>();
        collectPermutations(numbers, new boolean[numbers.size()], permutations, 0, 0);
        return permutations;
    }
    public static void collectPermutations(List<Integer> numbers, boolean[] visited, List<Integer> permutations, int curNumber, int curLength) {
        if (curLength == numbers.size()) {
            permutations.add(curNumber);
            return ;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                collectPermutations(numbers, visited, permutations, curNumber * 10 + numbers.get(i), curLength + 1);
                visited[i] = false;
            }
        }
    }
}
