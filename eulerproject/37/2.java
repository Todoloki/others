import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        
        boolean[] isNotPrime = new boolean[(N - 1 - 1) / 2 + 1];
        List<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> primes = new HashSet<Integer>();
        
        list.add(2);
        primes.add(2);
        long sum = 0;
        for (int i = 1; i < isNotPrime.length; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            list.add(2 * i + 1);
            primes.add(2 * i + 1);
            long nextIndex = (((long) 2 * i + 1) * (2 * i + 1) - 1) / 2;
            if (nextIndex >= isNotPrime.length) {
                continue;
            }
            for (int j = ((2 * i + 1) * (2 * i + 1) - 1) / 2; j < isNotPrime.length; j += 2 * i + 1) {
                isNotPrime[j] = true;
            }
        }
        int index = 0;
        while (index < list.size()) {
            int curPrime = list.get(index);
            index++;
            if (curPrime < 10) {
                continue;
            }
            int base = 1;
            while (curPrime / base > 9) {
                base *= 10;
            }
            int leftTruncate = curPrime;
            int rightTruncate = curPrime;
            boolean isValid = true;
            while (base != 1) {
                leftTruncate = leftTruncate - leftTruncate / base * base;
                rightTruncate = rightTruncate / 10;
                base /= 10;
                if (primes.contains(leftTruncate) == false || primes.contains(rightTruncate) == false) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                sum += curPrime;
            }
        }
        System.out.println(sum);
        scanner.close();
    }
}
// passed hackerrank
