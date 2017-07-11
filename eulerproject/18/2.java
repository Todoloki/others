import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        for (int i = 0; i < numOfCases; i++) {
            int n = scanner.nextInt();
            int[][] triangle = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= j; k++) {
                    triangle[j][k] = scanner.nextInt();
                }
            }
            for (int j = 1; j < n; j++) {
                triangle[j][0] += triangle[j - 1][0];
                triangle[j][j] += triangle[j - 1][j - 1];
                for (int k = 1; k < j; k++) {
                    triangle[j][k] += Math.max(triangle[j - 1][k], triangle[j - 1][k - 1]);
                }
            }
            int max = triangle[triangle.length - 1][0];
            for (int j = 1; j < triangle.length; j++) {
                max = Math.max(max, triangle[triangle.length - 1][j]);
            }
            System.out.println(max);
        }
    }
}
// passed hackerrank
