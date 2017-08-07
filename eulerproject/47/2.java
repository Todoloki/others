import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int limit = scanner.nextInt();
        int k = scanner.nextInt();
        limit += k - 1;
        boolean[] isNotPrime = new boolean[(limit - 1) / 2 + 1];
        int[] numOfFactors = new int[limit + 1];
        List<Integer> primes = new ArrayList<Integer>();
        
        primes.add(2);
        for (int i = 1; i < isNotPrime.length; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            primes.add(2 * i + 1);
            long nextIndex = i;
            nextIndex *= nextIndex;
            nextIndex -= 1;
            nextIndex /= 2;
            if (nextIndex >= isNotPrime.length) {
                continue ;
            }
            for (int j = ((2 * i + 1) * (2 * i + 1) - 1) / 2; j < isNotPrime.length; j += 2 * i + 1) {
                isNotPrime[j] = true;
            }
        }
        
        for (int i = 2; i < numOfFactors.length; i++) {
            int index = 0;
            int temp = i;
            int counter = 0;
            while (index < primes.size() && primes.get(index) <= (int) Math.floor(Math.sqrt(i))) {
                if (temp % primes.get(index) == 0) {
                    counter ++;
                    while (temp % primes.get(index) == 0) {
                        temp /= primes.get(index);
                    }
                    if (temp == 1) {
                        break;
                    }
                }
                index++;
            }
            if (temp != 1) {
                counter++;
            }
            numOfFactors[i] = counter;
        }
        for (int i = 2; i < numOfFactors.length - k + 1; i++) {
            boolean isValid = true;
            for (int j = 0; j < k; j++) {
                if (numOfFactors[i + j] != k) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                System.out.println(i);
            }
        }
        scanner.close();
    }
}
// passed hackerrank
