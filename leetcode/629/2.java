/**
 * Wanna play splatoon.
 */
import java.util.*;
public class Solution {
    public static void main(String [] args) {
        int n = 3;
        int k = 1;
        System.out.println(findNumPairs(n, k));
    }
    public static int findNumPairs(int n, int k) {
        if (n == 0) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        int res = 0;
        for (int i = 0; i <= Math.min(n - 1, k); i++) {
            res += findNumPairs(n - 1, k - i);
            res %= 1000000007;
        }
        return res;
    }
}
// if we know that for former n - 1 numbers, a inverse pairs exist
// then we add next number, we can create from 0 to n - 1 inverse pairs

// min(n - 1, k) is that we can create at most n - 1 inverse pairs, we just need to calculate for k inverse pairs
// for edge cases, if we do not have any numbers, the inverse pairs should be 0, (although I think n == 1 then we also need to 
// return 0

// and I change "n == 0" to "n == 1" then for n = 3, k = 1, I get 1 instead of 2
// I check if "k == 0" first and get 2

// reported to leetcode discussion
// just make the above change and I get the following

/**
 * Wanna play splatoon.
 */
import java.util.*;
public class Solution {
    public static void main(String [] args) {
        int n = 3;
        int k = 2;
        System.out.println(findNumPairs(n, k));
    }
    public static int findNumPairs(int n, int k) {
        if (k == 0) {
            return 1;
        }
        if (n == 1) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i <= Math.min(n - 1, k); i++) {
            res += findNumPairs(n - 1, k - i);
            res %= 1000000007;
        }
        return res;
    }
}

// time complexity for every call another at most n call is made T(n) = O(n) * T(n - 1) + O(n)
// at most n levels so the total time complexity is O(n ^ n)
// space complexity is O(n) becauses the recursion has at most n levels

// recursion is used here
// a lot of repeated sub problems
// solution for larger problem can be constructed by solution of small problem

// use a hashmap and use key as n + k, the number of inverse pairs is the value of the current hashmap

// memoizatation
/**
 * Wanna play splatoon.
 */
import java.util.*;
public class Solution {
    public static void main(String [] args) {
        int n = 3;
        int k = 2;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        System.out.println(findNumPairs(n, k, map));
    }
    public static int findNumPairs(int n, int k, HashMap<String, Integer> map) {
        String key = n + " " + k;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (k == 0) {
            return 1;
        }
        if (n == 1) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i <= Math.min(n - 1, k); i++) {
            res += findNumPairs(n - 1, k - i, map);
            res %= 1000000007;
        }
        map.put(key, res);
        return res;
    }
}
// time complexity O(n * k * n) because only O(n * k) cases will be calculated and filled
// and for each case, O(n) time is used to fill it.
// space complexity O(n * k) since we use hashmap here to store the result we already calcuated.

// how about tabulation
/**
 * Wanna play splatoon.
 */
import java.util.*;
public class Solution {
    public static void main(String [] args) {
        int n = 3;
        int k = 2;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                int sum = 0;
                // from j(max) to j - Math.min(i - 1, j) then Math.max(j - i + 1, 0)(min)
                for (int t = 0; t <= Math.min(i - 1, j); t++) {
                    sum += dp[i - 1][j - t];
                }
                dp[i][j] = sum;
            }
        }
        System.out.println(dp[n][k]);
    }
}
// time complexity O(n * k * n)
// space complexity O(n * k)

// a little bit improvement
/**
 * Wanna play splatoon.
 */
import java.util.*;
public class Solution {
    public static void main(String [] args) {
        int n = 3;
        int k = 2;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j <= k; j++) {
                if (j > i - 1) {
                    sum -= dp[i - 1][j - i];
                }
                sum += dp[i - 1][j];
                dp[i][j] = sum;
            }
        }
        System.out.println(dp[n][k]);
    }
}
// time complexity O(n * k)
// space complexity O(n * k)

// a bug exist above: the number can be very large, so mod 1000000007 is needed and also you need to make
// sure that every answer is not a negtive number
public class Solution {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j <= k; j++) {
                if (j > i - 1) {
                    sum -= dp[i - 1][j - i];
                }
                sum += dp[i - 1][j];
                sum %= 1000000007;
                sum += 1000000007;
                sum %= 1000000007;
                dp[i][j] = sum;
            }
        }
        return dp[n][k];
    }
}
