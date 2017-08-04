import java.io.*;
import java.util.*;

public class Mysample {
    public static void main(String[] args) {
        int limit = 1000000;
        int i = 1;
        long sum = 0;
        while (i < limit) {
            if (isPalindrome(i, 2) && isPalindrome(i, 10)) {
                sum += i;
            }
            i += 2;
        }
        System.out.println(sum);
    }
    public static boolean isPalindrome(int n, int base) {
        int reverse = 0;
        int temp = n;
        while (temp > 0) {
            reverse *= base;
            reverse += temp % base;
            temp /= base;
        }
        return reverse == n;
    }
}
// leading zeros is not possible, so the number which can be represented as a palindrome of base 2
// should be an odd number
