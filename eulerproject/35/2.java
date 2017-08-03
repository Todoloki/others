import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        
        boolean[] isNotPrime = new boolean[(N - 1 - 1) / 2 + 1];
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        HashSet<Integer> primes = new HashSet<Integer>();
        map.put(2, false);
        primes.add(2);
        long sum = 0;
        for (int i = 1; i < isNotPrime.length; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            map.put(2 * i + 1, false);
            primes.add(2 * i + 1);
            long nextIndex = (((long) 2 * i + 1) * (2 * i + 1) - 1) / 2;
            if (nextIndex >= isNotPrime.length) {
                continue;
            }
            for (int j = ((2 * i + 1) * (2 * i + 1) - 1) / 2; j < isNotPrime.length; j += 2 * i + 1) {
                isNotPrime[j] = true;
            }
        }
        for (int prime : primes) {
            if (map.get(prime)) {
                continue;
            }
            List<Integer> permutations = getPermutations(prime);
            if (containsAll(map, permutations)) {
                for (int i = 0; i < permutations.size(); i++) {
                    // System.out.println(permutations.get(i));
                    sum += permutations.get(i);
                }
            }
        }
        System.out.println(sum);
        scanner.close();
    }
    public static List<Integer> getPermutations(int n) {
        Set<Integer> res = new HashSet<Integer>();
        res.add(n);
        int base = 1;
        int length = 1;
        while (n / base > 9) {
            base *= 10;
            length++;
        }
        for (int i = 1; i < length; i++) {
            int newNumber = n % base * 10 + n / base;
            res.add(newNumber);
            n = newNumber;
        }
        List<Integer> permutations = new ArrayList<Integer>();
        for (int permutation : res) {
            permutations.add(permutation);
        }
        return permutations;
    }
    public static boolean containsAll(HashMap<Integer, Boolean> map, List<Integer> permutations) {
        boolean valid = true;
        for (int i = 0; i < permutations.size(); i++) {
            int permutation = permutations.get(i);
            if (map.containsKey(permutation)) {
                map.put(permutation, true);
            }
            else {
                valid = false;
            }
        }
        return valid;
    }
}
// passed hackerrank
