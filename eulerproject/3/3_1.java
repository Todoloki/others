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
        long largest = (long)Math.sqrt(num);
        boolean[] isNotPrime = new boolean[(int) largest + 1];
        for (int i = 2; i <= (int)largest; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            for (int j = 2; j <= (int)(largest / i); j++) {
                isNotPrime[j * i] = true;
            }
        }
        for (int i = (int)largest; i >= 2; i--) {
            if (isNotPrime[i] == false && num % i == 0) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
