/**
 * Wanna play splatoon.
 */
import java.util.*;
public class Solution {
    public static void main(String [] args)
    {
        // start from largest possible factor sqrt(num)
        // find the largest prime factor by decreasing the factor by one and check if this number is
        // a prime
        long num = new Long("600851475143");
        long factor = 2;
        long lastFactor = 1;
        while (factor <= num) {
            if (num % factor == 0) {
                lastFactor = factor;
                while (num % factor == 0) {
                    num /= factor;
                }
            }
            factor++;
        }
        System.out.println(lastFactor);
    }
}

// zelda if I was the programer responsible for checking if link's wearing women's cloth in desert town, just check
// if link is wearing it when he enters the town and after everytime he changes cloth in town he is still wearing the cloth
// that is called women's cloth
