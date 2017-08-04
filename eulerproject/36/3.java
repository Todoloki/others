import java.io.*;
import java.util.*;

public class Mysample {
    public static void main(String[] args) {
        int i = 1;
        long sum = 0;
        int temp = getPalindrome(i, true);
        int limit = 1000000;
        while (temp < limit) {
            if (isPalindrome(temp, 10)) {
                sum += temp;
            }
            i++;
            temp = getPalindrome(i, true);
        }
        i = 1;
        temp = getPalindrome(i, false);
        while (temp < limit) {
            if (isPalindrome(temp, 10)) {
                sum += temp;
            }
            i++;
            temp = getPalindrome(i, false);
        }
        System.out.println(sum);
    }
    public static int getPalindrome(int n, boolean isOdd) {
        int p = n;
        int temp = n;
        if (isOdd) {
            temp = temp / 2;
        }
        while (temp != 0) {
            p *= 2;
            p += temp % 2;
            temp /= 2;
        }
        return p;
    }
    public static boolean isPalindrome(int n, int base) {
        int reverse = 0;
        int temp = n;
        while (temp != 0) {
            reverse *= base;
            reverse += temp % base;
            temp /= base;
        }
        return reverse == n;
    }
}
