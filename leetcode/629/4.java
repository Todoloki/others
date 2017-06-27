import java.util.*;
public class Solution {
    public static void main(String [] args) {
        int n = 1000;
        int k = 1000;
        int[][] dp = new int[n + 1][k + 1];
        HashSet<String> set = new HashSet<String>();
        System.out.println(findNumPairs(n, k, set, dp));
    }
    public static int findNumPairs(int n, int k, HashSet<String> map, int[][] dp) {
        String key = n + " " + k;
        if (map.contains(key)) {
            return dp[n][k];
        }
        if (k == 0) {
            map.add(key);
            dp[n][k] = 1;
            return 1;
        }
        if (n == 0) {
            map.add(key);
            dp[n][k] = 0;
            return 0;
        }
        int sum = findNumPairs(n - 1, k, map, dp) + findNumPairs(n, k - 1, map, dp);
        if (k >= n) {
            sum -= findNumPairs(n - 1, k - n, map, dp);
        }
        sum %= 1000000007;
        sum += 1000000007;
        sum %= 1000000007;
        map.add(key);
        dp[n][k] = sum;
        return sum;
    }
}

// use memoizatation
// O(n * k) time O(n * k) space
