import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int limit = 28123;
        int maxSize = (int) Math.floor(Math.sqrt(limit));
        boolean[] isNotPrime = new boolean[(maxSize - 1) / 2 + 1];
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
        int numOfCases = scanner.nextInt();
        HashSet<Integer> abundants = new HashSet<Integer>();
        for (int i = 1; i <= limit; i++) {
            int sum = getSumOfProperDivisors(i, primes);
            if (sum > i) {
                // System.out.println(i);
                abundants.add(i);
            }
        }
        for (int i = 0; i < numOfCases; i++) {
            int num = scanner.nextInt();
            if (num > limit) {
                System.out.println("YES");
                continue;
            }
            boolean find = false;
            for (int j : abundants) {
                int target = num - j;
                if (abundants.contains(target)) {
                    find = true;
                    break;
                }
            }
            if (find) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
    public static int getSumOfProperDivisors(int num, List<Integer> primes) {
        if (num == 1) {
            return 0;
        }
        int sum = 1;
        int tempNum = num;
        for (int i = 0; i < primes.size(); i++) {
            int curPrime = primes.get(i);
            if (curPrime * curPrime > num) {
                sum *= (num + 1);
                break;
            }
            if (num % curPrime == 0) {
                int curPrimePlusOne = curPrime;
                while (num % curPrime == 0) {
                    num /= curPrime;
                    curPrimePlusOne *= curPrime;
                }
                sum *= curPrimePlusOne - 1;
                sum /= curPrime - 1;
                if (num == 1) {
                    break;
                }
            }
        }
        return sum - tempNum;
    }
}

// be careful that if a number is larger than the limit given by the problem's description
// we need to print yes because it is for sure can be sum of two abundant numbers
// others are same.
