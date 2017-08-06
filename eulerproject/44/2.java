import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        for (int k = K + 1; k < N; k++) {
            long pn = k;
            pn = pn * (3 * pn - 1);
            long pnmk = k - K;
            pnmk = pnmk * (3 * pnmk - 1);
            long t1 = pn - pnmk;
            long t2 = pn + pnmk;
            if (isPantagon(t1) || isPantagon(t2)) {
                System.out.println(pn / 2);
            }
        }
        scanner.close();
    }
    public static boolean isPantagon(long t) {
        long low = 1;
        long high = (long) Math.floor(Math.sqrt(t));
        while (low + 1 < high) {
            long mid = (low + high) / 2;
            if (mid * (3 * mid - 1) <= t) {
                low = mid;
            }
            else {
                high = mid;
            }
        }
        if (high * (3 * high - 1) == t) {
            return true;
        }
        if (low * (3 * low - 1) == t) {
            return true;
        }
        return false;
    }
}
// passed hackerrank
// binary search
