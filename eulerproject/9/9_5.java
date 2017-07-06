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
            int s = in.nextInt();
            // a = m ^ 2 - n ^ 2
            // b = 2 * m * n
            // c = m ^ 2 + n ^ 2
            
            // a + b + c = 2 * m * (m + n)
            
            // d * 2 * m * (m + n) = s;
            if (s % 2 == 1) {
                System.out.println(-1);
                continue;
            }
            int s2 = s / 2;
            int max = -1;
            for (int i = 1; i <= (int) Math.floor(Math.sqrt(s2)); i++) {
                int m = i;
                if (s2 % m == 0) {
                    int s2m = s2 / m;
                    int k = m % 2 == 0 ? m + 1 : m + 2;
                    while (k < m * 2 && k <= s2m) {
                        if (s2m % k == 0) {
                            int n = k - m;
                            int d = s2m / k;
                            int a = m * m - n * n;
                            int b = 2 * m * n;
                            int c = m * m + n * n;
                            a *= d;
                            b *= d;
                            c *= d;
                            max = Math.max(max, a * b * c);
                        }
                        k += 2;
                    }
                }
            }
            System.out.println(max);
        }
    }
}

// passed hackerrank
// the traditional one will cause TLE
// so the one with parametrisation will be used here.
