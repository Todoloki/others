import java.util.*;
import java.math.*;
import java.io.*;

public class Mysample {
    public static void main(String [] args) {
        int limit = 28123;
        HashSet<Integer> abundantNumbers = new HashSet<Integer>();
        int max = (int)Math.floor(Math.sqrt(limit));
        boolean[] isNotPrime = new boolean[(max - 1) / 2 + 1];
        for (int i = 1; i < isNotPrime.length; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            for (int j = ((2 * i + 1) * (2 * i + 1) - 1) / 2; j < isNotPrime.length; j += 2 * i + 1) {
                isNotPrime[j] = true;
            }
        }
        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        for (int i = 1; i < isNotPrime.length; i++) {
            if (isNotPrime[i] == false) {
                primes.add(2 * i + 1);
            }
        }
        for (int i = 1; i <= limit; i++) {
            int sum = getSumOfProperDivisors(i, primes);
            if (sum > i) {
                // System.out.println(i);
                abundantNumbers.add(i);
            }
        }
        long sumOfNotTwoAbundant = 0;
        for (int i = 1; i <= limit; i++) {
            boolean find = false;
            for (int abundant : abundantNumbers) {
                int target = i - abundant;
                if (abundantNumbers.contains(target)) {
                    // System.out.println(i);
                    find = true;
                    break;
                }
            }
            if (find == false) {
                sumOfNotTwoAbundant += i;
            }
        }
        // System.out.println(getSumOfProperDivisors(12, primes));
        System.out.println(sumOfNotTwoAbundant);
    }
    public static int getSumOfProperDivisors(int num, List<Integer> primes) {
        int sum = 1;
        if (num == 1) {
            return 0;
        }
        int tempNum = num;
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
