import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        boolean[] isNotPrime = new boolean[1000];
        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        for (int i = 1; i < isNotPrime.length; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            for (int j = ((2 * i + 1) * (2 * i + 1) - 1) / 2; j < isNotPrime.length; j += 2 * i + 1) {
                isNotPrime[j] = true;
            }
        }
        for (int i = 1; i < isNotPrime.length; i++) {
            if (isNotPrime[i] == false) {
                primes.add(2 * i + 1);
            }
        }
        
        for (int i = 0; i < numOfCases; i++) {
            int limit = scanner.nextInt();
            int formerCounter = 1;
            int curNumber = 2;
            int curCounter = 1;
            while (formerCounter * curCounter <= limit) {
                curNumber++;
                formerCounter = curCounter;
                curCounter = 1;
                int temp = curNumber;
                if (temp % 2 == 0) {
                    temp /= 2;
                }
                for (int j = 0; j < primes.size(); j++) {
                    if (primes.get(j) * primes.get(j) > temp) {
                        curCounter *= 2;
                        break;
                    }
                    int times = 0;
                    while (temp % primes.get(j) == 0) {
                        temp /= primes.get(j);
                        times++;
                    }
                    curCounter *= (times + 1);
                    if (temp == 1) {
                        break;
                    }
                }
                // System.out.println(formerCounter + " " + curCounter);
            }
            System.out.println(curNumber * (curNumber - 1) / 2);
        }
    }
}

// we just need to multiply the number by 2 if it is not a perfect square
// used information we already know, for 500th the number is less than 10 ^ 7
// then for more than 1000 divisor, the result will not exceed 10 ^ 8
// which means if we use d(s) = d(n) * d(n + 1) / 2
// than maximum n will not exceed 10 ^ 4
// we just check under square root of each number, so just a list under 1000 will be enough to solve this problem.
