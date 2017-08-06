import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        int limit = 500000;
        boolean[] isNotPrime = new boolean[(limit - 1) / 2 + 1];
        List<Integer> primes = new ArrayList<Integer>();
        for (int i = 1; i < isNotPrime.length; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            primes.add(2 * i + 1);
            long nextIndex = i;
            nextIndex = ((2 * nextIndex + 1) *  (2 * nextIndex + 1) - 1) / 2;
            if (nextIndex >= isNotPrime.length) {
                continue;
            }
            for (int j = ((2 * i + 1) * (2 * i + 1) - 1) / 2; j < isNotPrime.length; j += 2 * i + 1) {
                isNotPrime[j] = true;
            }
        }
        
        for (int i = 0; i < numOfCases; i++) {
            int curCase = scanner.nextInt();
            int index = 0;
            int counter = 0;
            while (index < primes.size() && primes.get(index) < curCase) {
                int maybeSquare = (curCase - primes.get(index)) / 2;
                int maybeSquareRoot = (int) Math.floor(Math.sqrt(maybeSquare));
                if (maybeSquareRoot * maybeSquareRoot == maybeSquare) {
                    counter++;
                }
                index++;
            }
            System.out.println(counter);
        }
        scanner.close();
    }
}
// passed hackerrank
