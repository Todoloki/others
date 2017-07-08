import java.util.*;
import java.math.*;
public class Solution {
    public static void main(String [] args) {
        int limit = 500;
        int n = 1;
        int primeMax = (int) Math.floor(Math.sqrt(Integer.MAX_VALUE));
        boolean[] isNotPrime = new boolean[(primeMax - 1) / 2 + 1];
        for (int i = 1; i <= isNotPrime.length - 1; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            for (int j = ((2 * i + 1) * (2 * i + 1) - 1) / 2; j <= isNotPrime.length - 1; j += 2 * i + 1) {
                isNotPrime[j] = true;
            }
        }
        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        for (int i = 1; i <= isNotPrime.length - 1; i++) {
            if (isNotPrime[i] == false) {
                primes.add(2 * i + 1);
            }
        }
        int counter = 0;
        int curNumber = 1;
        while (counter <= limit) {
            curNumber++;
            n += curNumber;
            counter = 1;
            int temp = n;
            for (int i = 0; i < primes.size(); i++) {
                if (temp % primes.get(i) == 0) {
                    int times = 0;
                    while (temp % primes.get(i) == 0) {
                        times++;
                        temp /= primes.get(i);
                    }
                    counter *= times + 1;
                    if (temp == 1) {
                        break;
                    }
                }
            }
        }
        System.out.println(n);
    }
}
