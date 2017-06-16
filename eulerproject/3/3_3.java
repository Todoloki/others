/**
 * Wanna play splatoon.
 */
 
 // when use 3_1.java O(n) operation
 // this solution improved the former one by reduce the number of operations to around half of original 
 // by checking for if num can be divided by 2 and then increase 2 to the factor instead of one.
import java.util.*;
public class Solution {
    public static void main(String [] args)
    {
        // start from largest possible factor sqrt(num)
        // find the largest prime factor by decreasing the factor by one and check if this number is
        // a prime
        long num = new Long("600851475143");
        long factor = 3;
        long lastFactor = 1;
        while (num % 2 == 0) {
            lastFactor = 2;
            num %= 2;
        }
        while (factor <= num) {
            if (num % factor == 0) {
                lastFactor = factor;
                while (num % factor == 0) {
                    num /= factor;
                }
            }
            factor += 2;
        }
        System.out.println(lastFactor);
    }
}
