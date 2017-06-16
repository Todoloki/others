/**
 * Wanna play splatoon.
 */
import java.util.*;
public class Solution {
    public static void main(String [] args)
    {
        long product = 1;
        for (int i = 2; i <= 20; i++) {
            long gcd = getGCD(product, i);
            product = product / gcd * i;
        }
        System.out.println(product);
    }
    public static long getGCD(long l1, long l2) {
        if (l1 == 1 || l2 == 1) {
            return 1;
        }
        if (l1 < l2) {
            long temp = l1;
            l1 = l2;
            l2 = temp;
        }
        if (l1 % l2 == 0) {
            return l2;
        }
        return getGCD(l2, l1 % l2);
    }
}
// get greatest common divisor and least common multiplier for all numbers from 1 to n
