/**
 * Wanna play splatoon.
 */
 
 // we can know that largest factor will exceed the square root of the original number
 
 // Possible bug: use the sqrt(num) instead of sqrt(tempNum) but we can only know that the factor is less
 // or equal to the square of the original root,
 // there is no guarantee that it will be less or equal to sqrt(tempNum)
import java.util.*;
public class Solution {
    public static void main(String [] args)
    {
        // start from largest possible factor sqrt(num)
        // find the largest prime factor by decreasing the factor by one and check if this number is
        // a prime
        long num = new Long("600851475143");
        long tempNum = num;
        long factor = 3;
        long lastFactor = 1;
        while (num % 2 == 0) {
            lastFactor = 2;
            num %= 2;
        }
        while (factor <= (long)Math.sqrt(tempNum)) {
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
