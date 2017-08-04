import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        
        int i = 1;
        int temp = getPalindrome(i, true);
        long sum = 0;
        while (temp < N) {
            if (isPalindrome(temp, K)) {
                sum += temp;
            }
            i++;
            temp = getPalindrome(i, true);
        }
        
        i = 1;
        temp = getPalindrome(i, false);
        while (temp < N) {
            if (isPalindrome(temp, K)) {
                sum += temp;
            }
            i++;
            temp = getPalindrome(i, false);
        }
        System.out.println(sum);
        scanner.close();
    }
    public static int getPalindrome(int n, boolean isOddLength) {
        int p = n;
        int temp = n;
        if (isOddLength) {
            temp /= 10;
        }
        while (temp != 0) {
            p *= 10;
            p += temp % 10;
            temp /= 10;
        }
        return p;
    }
    public static boolean isPalindrome(int n, int k) {
        int reverse = 0;
        int temp = n;
        while (temp != 0) {
            reverse *= k;
            reverse += temp % k;
            temp /= k;
        }
        return reverse == n;
    }
}
// passed hackerrank
