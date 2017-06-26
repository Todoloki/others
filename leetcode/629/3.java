import java.util.*;
public class Solution {
    public static void main(String [] args) {
        int n = 3;
        int k = 1;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        System.out.println(findNumPairs(n, k, map));
    }
    public static int findNumPairs(int n, int k, HashMap<String, Integer> map) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                int sum = 0;
                if (j > i - 1) {
                    sum -= dp[i - 1][j - i];
                }
                sum += dp[i][j - 1] + dp[i - 1][j];
                sum %= 1000000007;
                sum += 1000000007;
                sum %= 1000000007;
                dp[i][j] = sum;
            }
        }
        return dp[n][k];
    }
}
// instead of using cumulative sum
// use the former grid that we just filled
// O(n * k) time O(n * k) space
