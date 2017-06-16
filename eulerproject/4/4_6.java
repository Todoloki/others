import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int largest = 0;
            for (int i = 999; i >= 100; i--) {
                for (int j = Math.min(999, n / i); j >= 100; j--) {
                    int product = i * j;
                    if (product < largest) {
                        break;
                    }
                    if (isParlindrome(product)) {
                        largest = Math.max(largest, product);
                        //System.out.println(i + " " + j);
                    }
                }
            }
            System.out.println(largest);
        }
    }
    public static boolean isParlindrome(int num) {
        int tempNum = num;
        int sum = 0;
        while (num != 0) {
            sum *= 10;
            sum += num % 10;
            num /= 10;
        }
        return tempNum == sum;
    }
}

// for hackerrank
// if we use first three digit, time complexity will be the same
// bug: not use Min(999, n / i) will not guarantee j is a three-digit number
// since numerate 100 - 900 is 10^3 and we also need 10^3 to check if the parlindrome 6-digit number can be product of two three-digit numbers
