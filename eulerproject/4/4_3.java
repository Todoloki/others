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
        for (int i = 100; i <= 999; i++) {
            for (int j = i; j <= 999; j++) {
                int product = i * j;
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
// reduce half the operations needed for former solution
