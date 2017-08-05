import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int limit = 5000000;
        int[] table = new int[limit + 1];
        
        for (int m = 1; m <= (int)Math.floor(Math.sqrt(limit / 2)); m++) {
            int mn = m % 2 == 0 ? m + 1 : m + 2;
            while (mn < 2 * m) {
                if (getGCD(m, mn - m) != 1) {
                    mn += 2;
                    continue ;
                }
                int sum = 2 * m * mn;
                while (sum <= limit) {
                    table[sum]++;
                    sum += 2 * m * mn;
                }
                mn += 2;
            }
        }
        int[] maxes = new int[limit + 1];
        int max = 0;
        int maxCounter = 0;
        for (int i = 0; i < maxes.length; i++) {
            if (table[i] > maxCounter) {
                maxCounter = table[i];
                max = i;
            }
            maxes[i] = max;
        }
        int numOfCases = scanner.nextInt();
        for (int i = 0; i < numOfCases; i++) {
            int curCase = scanner.nextInt();
            System.out.println(maxes[curCase]);
        }
        scanner.close();
    }
    public static int getGCD(int a, int b) {
        if (a <= 1 || b <= 1) {
            return 1;
        }
        if (a < b) {
            int temp = a;
            a = b; 
            b = temp;
        }
        if (a % b == 0) {
            return b;
        }
        return getGCD(b, a % b);
    }
}
