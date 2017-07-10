import java.util.*;
import java.math.*;
public class Solution {
    public static void main(String [] args) {
        // should be careful because the number can be more than the largest number that can be represented using Integer
        long[][] grid = new long[20 + 1][20 + 1];
        grid[0][0] = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                long sum = 0;
                if (i > 0) {
                    sum += grid[i - 1][j];
                }
                if (j > 0) {
                    sum += grid[i][j - 1];
                }
                grid[i][j] = sum;
            }
        }
        System.out.println(grid[20][20]);
    }
}
// using tabulation
//  O(n * n) time and space
