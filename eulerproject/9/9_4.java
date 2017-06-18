/**
 * Wanna play splatoon.
 */
import java.util.*;
public class Solution {
    public static void main(String [] args) {

        // a + b + c = 1000
        // a ^ 2 + b ^ 2 = c ^ 2
        // a = m ^ 2 - n ^ 2
        // b = 2 * m * n
        // c = m ^ 2 + n ^ 2
        // so we can already know that a ^ 2 + b ^ 2 = c ^ 2

        // a + b + c = 2 * m ^ 2 + 2 * m * n = 2 * (m + n) * m

        // if we can divide a same number from both sides, let's say its value is gcd(a, b, c)
        // that means, after dividing this number, gcd(a, b, c) = 1
        // if a, b both are even numbers, then it means that c is also a even number
        // as gcd(a, b) = 1, if a, b are both odd numbers, then c need to be 2
        // which is not possible

        // so one of a, b is a even number

        // *too complex
        // *what if errors occur.

        // so we need to find a integer that is less than or equal to ceiling(sqrt(sum / 2)) - 1
        // then we can get sum / 2 / m which is m + n
        // a is odd b is even, c is odd
        // we can know that m and m + n are both odd number or both even number
        // we need to find m + n which is a factor of sum / 2 / m
        // and m + n > m and m + n < 2 * m since a is a natural number

        // from m + 1 (m is even) or m + 2 (m is odd), since m + n should be odd
        // maximum for m + n is less than 2 * m, less or equal to sum / 2 / m and should be a divisor of sum / 2 / m

        // we can define the original d we used to be a divisor of two sides.

        int sum = 1000;

        int max = (int) Math.ceil(Math.sqrt(sum / 2)) - 1;

        for (int i = 2; i <= max; i++) {
            int m = i;
            if (sum % (2 * m) != 0) {
                continue;
            }
            int sumMN = sum / 2 / m;
            int minN = (m % 2 == 1) ? m + 2 : m + 1;
            int maxN = Math.min(2 * m - 1, sumMN);
            for (int j = minN; j <= maxN; j += 2) {
                if (sumMN % j == 0 && getGCD(i, j) == 1) {
                    int d = sum / 2 / m / j;
                    int MPlusN = sum / m / 2 / d;
                    int n = MPlusN - m;
                    int a = m * m - n * n;
                    int b = m * n * 2;
                    int c = m * m + n * n;
                    System.out.println(a * b * c * d * d * d);
                }
            }
        }
    }
    public static int getGCD(int i1, int i2) {
        if (i1 == 1 || i2 == 1) {
            return 1;
        }
        if (i1 < i2) {
            int temp = i1;
            i1 = i2;
            i2 = temp;
        }
        if (i1 % i2 == 0) {
            return i2;
        }
        return getGCD(i2, i1 % i2);
    }
}

// very complex, maybe I will not remember this one any more
