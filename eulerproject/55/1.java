import java.io.*;
import java.util.*;
import java.math.*;

public class Mysample {
    public static void main(String[] args) {
        int limit = 10000;
        int counter = 0;

        for (int t = 0; t < limit; t++) {
            int times = 0;
            String num = "" + t;
            char[] nums = num.toCharArray();
            int[] numbers = new int[nums.length];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = nums[i] - '0';
            }
            boolean isLychrel = true;
            while (times < 50) {
                times++;
                int[] reverse = new int[numbers.length];
                for (int i = 0; i < numbers.length; i++) {
                    reverse[i] = numbers[numbers.length - 1 - i];
                }
                int[] sum = new int[reverse.length];
                int c = 0;
                for (int i = sum.length - 1; i >= 0; i--) {
                    sum[i] = numbers[i] + reverse[i] + c;
                    c = sum[i] / 10;
                    sum[i] %= 10;
                }
                if (c > 0) {
                    int[] temp = new int[sum.length + 1];
                    temp[0] = c;
                    for (int i = 1; i < temp.length; i++) {
                        temp[i] = sum[i - 1];
                    }
                    sum = temp;
                }
                int left = 0;
                int right = sum.length - 1;
                boolean isPalindrome = true;
                while (left < right) {
                    if (sum[left] != sum[right]) {
                        isPalindrome = false;
                        break;
                    }
                    left++;
                    right--;
                }
                if (isPalindrome) {
                    isLychrel = false;
                    break;
                }
                numbers = sum;
            }
            if (isLychrel) {
                // System.out.println(t);
                counter++;
            }
        }
        System.out.println(counter);
    }
}
