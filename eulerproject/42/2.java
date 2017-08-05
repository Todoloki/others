import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        for (int i = 0; i < numOfCases; i++) {
            long curCase = scanner.nextLong();
            long n = (long)Math.floor(Math.sqrt(curCase * 2));
            if (n * (n + 1) == curCase * 2) {
                System.out.println(n);
            }
            else {
                System.out.println(-1);
            }
        }
        scanner.close();
    }
}
// passed hackerrank
