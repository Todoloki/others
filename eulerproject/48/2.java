import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long sum = 0;
        long modNumber = 1;
        for (int i = 0; i < 10; i++) {
            modNumber *= 10;
        }
        for (int i = 1; i <= N; i++) {
            long power = getPower(i, i, modNumber);
            sum += power;
            sum %= modNumber;
        }
        System.out.println(sum);
        scanner.close();
    }
    public static long getPower(int base, int times, long modNumber) {
        if (times == 0) {
            return 1;
        }
        if (times == 1) {
            return base;
        }
        int t2 = times / 2;
        long power = getPower(base, t2, modNumber);
        power = getLastTenDigitOfSquare(power);
        
        if (times % 2 == 1) {
            power *= base;
            power %= modNumber;
        }
        
        return power;
    }
    public static long getLastTenDigitOfSquare(long power) {
        String s = new StringBuffer("" + power).reverse().toString();
        int[] product = new int[s.length() * 2];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i + j >= 10) {
                    break;
                }
                product[i + j] += (s.charAt(i) - '0') * (s.charAt(j) - '0');
            }
        }
        StringBuffer sb = new StringBuffer();
        int c = 0;
        for (int i = 0; i < Math.min(10, product.length); i++) {
            int sum = product[i] + c;
            c = sum / 10;
            sum %= 10;
            sb.append(sum);
        }
        return Long.parseLong(sb.reverse().toString());
    }
}
// hackerrank
// can not pass last test case
