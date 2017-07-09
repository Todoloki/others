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
        int curNumber = 1;
        int formerCounter = 1;
        int curCounter = 1;
        while (curCounter * formerCounter <= limit) {
            formerCounter = curCounter;
            curCounter = 1;
            curNumber++;
            int temp = curNumber;
            if (temp % 2 == 0) {
                temp /= 2;
            }
            for (int i = 0; i < primes.size(); i++) {
                if (primes.get(i) * primes.get(i) > temp) {
                    curCounter *= 2;
                    if (i > 0 && primes.get(i - 1) * primes.get(i - 1) == temp) {
                        curCounter--;
                    }
                    break;
                }
                int times = 0;
                while (temp % primes.get(i) == 0) {
                    temp /= primes.get(i);
                    times++;
                }
                curCounter *= times + 1;
                if (temp == 1) {
                    break;
                }
            }
        }
        System.out.println(curNumber * (curNumber - 1) / 2);
    }
}
