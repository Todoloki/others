/**
 * Wanna play splatoon.
 */
import java.util.*;
public class Solution {
    public static void main(String [] args)
    {
        // first let's prove that our product is a multiple of 11
        // num = 100000 * x + 10000 * y + 1000 * z + 100 * z + 10 * y + x
        //      = 100001 * x + 10010 * y + 1100 * z
        //      = 11 * 9091 * x + 11 * 901 + 11 * 100 * z
        int largest = 0;
        for (int i = 999; i >= 100; i--) {
            int decrease = 0;
            int max = 0;
            if (i % 11 == 0) {
                max = 999;
                decrease = -1;
            }
            else {
                max = 990;
                decrease = -11;
            }
            for (int j = max; j >= i; j += decrease) {
                int product = i * j;
                if (product < largest) {
                    break;
                }
                if (isParlindrome(product)) {
                    largest = Math.max(largest, product);
                }
            }
        }
        System.out.println(largest);
    }
    public static boolean isParlindrome(int product) {
        int num = 0;
        int tempProduct = product;
        while (product != 0) {
            num *= 10;
            num += product % 10;
            product /= 10;
        }
        return num == tempProduct;
    }
}
