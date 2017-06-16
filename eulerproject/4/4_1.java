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
        int num = 999;
        while (num >= 100) {
            String number = "" + num + new StringBuffer("" + num).reverse().toString();
            int product = Integer.parseInt(number);
            for (int i = 999; i >= 100; i--) {
                if (product % i == 0 && product / i >= 100 && product / i <= 999) {
                    System.out.println(product);
                    return ;
                }
            }
            num--;
        }
        System.out.println("0");
    }
}
