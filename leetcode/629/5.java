import java.util.*;
public class Solution {
    public static void main(String [] args) {
        int n = 1000;
        int k = 1000;
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int[] temp = new int[k + 1];
            temp[0] = 1;
            for (int j = 1; j <= k; j++) {
                temp[j] = temp[j - 1];
                temp[j] += dp[j];
                temp[j] %= 1000000007;
                temp[j] += 1000000007;
                temp[j] %= 1000000007;
                if (j >= i) {
                    temp[j] -= dp[j - i];
                }
                temp[j] %= 1000000007;
                temp[j] += 1000000007;
                temp[j] %= 1000000007;
            }
            dp = temp;
        }
        System.out.println(dp[k]);
    }
}
// one dimentional dynamic programming
// O(k) space
// O(n * k) time
