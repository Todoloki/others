import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int numOfCase = scanner.nextInt();
        String[] numbers = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
        String[] teens = new String[]{"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = new String[]{"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        for (int i = 0; i < numOfCase; i++) {
            long number = scanner.nextLong();
            if (number == 0) {
                System.out.println("Zero");
            }
            int num = (int)(number / 1000000000);
            number -= (long) num * 1000000000;
            StringBuffer sb = new StringBuffer();
            // System.out.println(num);
            if (num > 0) {
                int h = num / 100;
                num -= h * 100;
                int t = num / 10;
                num -= t * 10;
                int s = num;
                if (h >= 1) {
                    sb.append(numbers[h - 1] + " " + "Hundred ");
                }
                if (t == 1) {
                    if (s == 0) {
                        sb.append(numbers[10 - 1] + " ");
                    }
                    else {
                        sb.append(teens[t * 10 + s - 11] + " ");
                    }
                }
                else if (t >= 2) {
                    sb.append(tens[t - 2] + " ");
                }
                if ((t >= 2 || t == 0) && s >= 1) {
                    sb.append(numbers[s - 1] + " ");
                }
                sb.append("Billion ");
            }
            num = (int)(number / 1000000);
            number -= (long) num * 1000000;
            //System.out.println(num);
            if (num > 0) {
                int h = num / 100;
                num -= h * 100;
                int t = num / 10;
                num -= t * 10;
                int s = num;
                if (h >= 1) {
                    sb.append(numbers[h - 1] + " " + "Hundred ");
                }
                if (t == 1) {
                    if (s == 0) {
                        sb.append(numbers[10 - 1] + " ");
                    }
                    else {
                        sb.append(teens[t * 10 + s - 11] + " ");
                    }
                }
                else if (t >= 2) {
                    sb.append(tens[t - 2] + " ");
                }
                if ((t >= 2 || t == 0) && s >= 1) {
                    sb.append(numbers[s - 1] + " ");
                }
                sb.append("Million ");
            }
            num = (int)(number / 1000);
            number -= num * 1000;
            if (num > 0) {
                int h = num / 100;
                num -= h * 100;
                int t = num / 10;
                num -= t * 10;
                int s = num;
                if (h >= 1) {
                    sb.append(numbers[h - 1] + " " + "Hundred ");
                }
                if (t == 1) {
                    if (s == 0) {
                        sb.append(numbers[10- 1] + " ");
                    }
                    else {
                        sb.append(teens[t * 10 + s - 11] + " ");
                    }
                }
                else if (t >= 2) {
                    sb.append(tens[t - 2] + " ");
                }
                if ((t >= 2 || t == 0) && s >= 1) {
                    sb.append(numbers[s - 1] + " ");
                }
                sb.append("Thousand ");
            }
            num = (int) number;
            if (num > 0) {
                int h = num / 100;
                num -= h * 100;
                int t = num / 10;
                num -= t * 10;
                int s = num;
                if (h >= 1) {
                    sb.append(numbers[h - 1] + " " + "Hundred ");
                }
                if (t == 1) {
                    if (s == 0) {
                        sb.append(numbers[10 - 1] + " ");
                    }
                    else {
                        sb.append(teens[t * 10 + s - 11] + " ");
                    }
                }
                else if (t >= 2) {
                    sb.append(tens[t - 2] + " ");
                }
                if ((t >= 2 || t == 0) && s >= 1) {
                    sb.append(numbers[s - 1] + " ");
                }
            }
            sb.delete(sb.length() - 1, sb.length());
            System.out.println(sb.toString());
        }
    }
}
// passed hackerrank
