import java.util.*;
import java.math.*;
public class Solution {
    public static void main(String [] args) {
        int limit = 2000000;
        long sum = 2;
        for (int i = 3; i <= limit; i += 2) {
            if (isPrime(i)) {
                //System.out.println(i);
                sum += i;
            }
        }
        System.out.println(sum);
    }
    public static boolean isPrime(int i) {
        if (i < 4) {
            return true;
        }
        if (i % 3 == 0) {
            return false;
        }
        int divisor = 6;
        while (divisor - 1 <= (int)Math.floor(Math.sqrt(i))) {
            if (i % (divisor  - 1) == 0) {
                return false;
            }
            if (divisor + 1 > (int)Math.floor(Math.sqrt(i))) {
                break;
            }
            if (i % (divisor + 1) == 0) {
                return false;
            }
            divisor += 6;
            //System.out.println(divisor + " " + i);
        }
        return true;
    }
}
// use the improved solution for checking a number is a prime number or not

// first, we just consider all number less than n, and check if every number less than n and larger or equal to 2 is a
// divisor of n, if we can not find such a number, then n is a prime number

// second, we check for 2 and all odd numbers that are less than n

// third, we will check for 2 and all odd number less or equal to floor(sqrt(n))

// forth, we will check just for 2, 3, odd nubmers that can be represented as 6*n - 1 or 6*n + 1
// but it is not the optimal solution for this problem.
