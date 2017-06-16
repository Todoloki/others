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
        int largest = 0;
        for (int i = 999; i >= 100; i--) {
            for (int j = 999; j >= i; j--) {
                int product = i * j;
                if (product < largest) {
                    break;
                }
                if (product == getReverse(product)) {
                    largest = Math.max(largest, product);
                }
            }
        }
        System.out.println(largest);
    }
    public static int getReverse(int product) {
        int num = 0;
        while (product != 0) {
            num *= 10;
            num += product % 10;
            product /= 10;
        }
        return num;
    }
}

// this solution can allow us to finish calculation more quickly since we stop checking for further possibilities when
// we can make sure that for the current number we will not be able to find any other number that can archieve 
// larget product
