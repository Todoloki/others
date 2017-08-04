import java.io.*;
import java.util.*;

public class Mysample {
    public static void main(String[] args) {
        int limit = 1000000;
        long sum = 0;
        for (int i = 1; i < limit; i++) {
            if (isPalindrome("" + i)) {
                String s = getBinaryRepresentation(i);
                if (isPalindrome(s)) {
                    sum += i;
                }
            }
        }
        System.out.println(sum);
    }
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static String getBinaryRepresentation(int i) {
        StringBuffer sb = new StringBuffer();
        while (i != 0) {
            sb.append(i % 2);
            i /= 2;
        }
        return sb.reverse().toString();
    }
}
