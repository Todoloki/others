import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        int limit = 100000;
        int max = (int) Math.floor(Math.sqrt(limit));
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
        int[] map = new int[limit];
        int sum = 0;
        for (int i = 1; i < limit; i++) {
            int sumOfDivisors = getSumOfDivisors(i, primes);
            if (sumOfDivisors != i && sumOfDivisors >= 1 && getSumOfDivisors(sumOfDivisors, primes) == i) {
                sum += i;
            }
            map[i] = sum;
        }
        // System.out.println(map[9999]);
        for (int i = 0; i < numOfCases; i++) {
            int num = scanner.nextInt();
            System.out.println(map[num - 1]);
        }
    }
    public static int getSumOfDivisors(int num, List<Integer> primes) {
        int tempNum = num;
        int sum = 1;
        if (num == 1) {
            return 0;
        }
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
                if (num == 1) {
                    break;
                }
            }
        }
        return sum - tempNum;
    }
}
// passed hackerrank
// should be careful because maybe one of the numbers that belong to a pair of amicable number is not under limit.
