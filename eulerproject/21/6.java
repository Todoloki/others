import java.util.*;
import java.math.*;
public class Solution {
    public static void main(String [] args) {
        int limit = 10000;
        int sum = 0;
        int maxLimit = (int)Math.floor(Math.sqrt(limit));
        boolean[] isNotPrime = new boolean[(maxLimit - 1) / 2 + 1];
        List<Integer> primes = new ArrayList<Integer>();
        // System.out.println(isNotPrime.length);
        for (int i = 1; i < isNotPrime.length; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            // System.out.println(2 * i + 1);
            for (int j = ((2 * i + 1) * (2 * i + 1) - 1) / 2; j < isNotPrime.length; j += 2 * i + 1) {
                isNotPrime[j] = true;
            }
        }
        primes.add(2);
        for (int i = 1; i < isNotPrime.length; i++) {
            if (isNotPrime[i] == false) {
                primes.add(2 * i + 1);
            }
        }
        for (int i = 1; i < limit; i++) {
            int sumOfI = getSumOfDivisor(i, primes);
            if (sumOfI > i && getSumOfDivisor(sumOfI, primes) == i) {
                sum += i;
                sum += sumOfI;
            }
        }
        System.out.println(sum);
    }
    public static int getSumOfDivisor(int num, List<Integer> primes) {
        if (num == 1) {
            return 0;
        }
        int tempNum = num;
        int sum = 1;
        for (int i = 0; i < primes.size(); i++) {
            int curPrime = primes.get(i);
            if (curPrime * curPrime > num) {
                sum *= (num + 1);
                break;
            }
            if (num % curPrime == 0) {
                int curPrimeTimesPlusOne = curPrime;
                while (num % curPrime == 0) {
                    num /= curPrime;
                    curPrimeTimesPlusOne *= curPrime;
                }
                sum *= curPrimeTimesPlusOne - 1;
                sum /= curPrime - 1;
            }
            if (num == 1) {
                break;
            }
        }
        return sum - tempNum;
    }
}
// using N(p ^ a) = p ^ (a + 1) - 1 / p - 1
// can be deducted
// N(a) * N(b) = N(a * b)
// improve the getSumOfAllDivisors method.
