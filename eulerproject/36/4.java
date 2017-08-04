import java.io.*;
import java.util.*;

public class Mysample {
    public static void main(String[] args) {
        int limit = 1000000;
        int i = 1;
        int temp = getPalindrome(i, true);
        long sum = 0;
        while (temp < limit) {
            if (isPalindrome(temp)) {
                sum += temp;
            }
            i++;
            temp = getPalindrome(i, true);
        }
        i = 1;
        temp = getPalindrome(i, false);
        while (temp < limit) {
            if (isPalindrome(temp)) {
                sum += temp;
            }
            i++;
            temp = getPalindrome(i, false);
        }
        System.out.println(sum);
    }
    public static int getPalindrome(int n, boolean isOdd) {
        int temp = n;
        int p = n;
        if (isOdd) {
            temp /= 10;
        }
        while (temp != 0) {
            p *= 10;
            p += temp % 10;
            temp /= 10;
        }
        return p;
    }
    public static boolean isPalindrome(int n) {
        int reverse = 0;
        int temp = n;
        while (temp != 0) {
            reverse *= 2;
            reverse += temp % 2;
            temp /= 2;
        }
        return reverse == n;
    }
}
// base 2 can also allow bit operation which can be operated by shifting
