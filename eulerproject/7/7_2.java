/**
 * Wanna play splatoon.
 */
import java.util.*;
public class Solution {
    public static void main(String [] args)
    {
        int maxSize = 10001;
        int start = 1;
        int counter = 1;
        while (counter < maxSize) {
            start += 2;
            if (isPrime(start)) {
                counter++;
            }
        }
        System.out.println(start);
    }
    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        if (n < 4) {
            return true;
        }
        if (n % 3 == 0) {
            return false;
        }
        if (n < 9) {
            return true;
        }
        int divisor = 5;
        while (divisor <= (int)(Math.floor(Math.sqrt(n)))) {
            if (n % divisor == 0) {
                return false;
            }
            if (n % (divisor + 2) == 0) {
                return false;
            }
            divisor += 6;
        }
        return true;
    }
}
// prime number start from 2, 3
// others can be 6 * n - 1 or 6 * n + 1
// if a number can not find a divisor that is larger than floor(sqrt(n)) than it is a prime number
// O(1) space
// O(n * n) time
