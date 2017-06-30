import java.util.*;
public class Solution {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        for (int i = 0; i < numOfCases; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] dp = new int[n + 1];
            for (int j = 1; j < dp.length; j++) {
                dp[j] = -1;
            }
            for (int j = 0; j < n; j++) {
                int[] pies = new int[m];
                for (int k = 0; k < m; k++) {
                    pies[k] = scanner.nextInt();
                }
                Arrays.sort(pies);
                for (int k = 1; k < m; k++) {
                    pies[k] += pies[k - 1];
                }
                for (int k = 0; k < m; k++) {
                    pies[k] += (k + 1) * (k + 1);
                }
                /*
                for (int k = 0; k < pies.length; k++) {
                    System.out.print(pies[k] + " ");
                }
                System.out.println("");
                */
                for (int k = Math.min(n, m * (j + 1)); k >= j + 1; k--) {
                    for (int t = 0; t < Math.min(k - j, m); t++) {
                        if (dp[k - (t + 1)] >= 0) {
                            if (dp[k] < 0)
                                dp[k] = dp[k - (t + 1)] + pies[t];
                            else {
                                dp[k] = Math.min(dp[k - (t + 1)] + pies[t], dp[k]);
                            }
                        }
                    }
                }
                /*
                for (int k = 0; k < dp.length; k++) {
                    System.out.print(dp[k] + " ");
                }
                System.out.println("");

                */
            }
            System.out.print("Case #" + (i + 1) + ": ");
            System.out.println(dp[n]);
        }
    }
}
// dynamic programming
// n * (m + mlogm + n * m) O(m * n * n)
// O(n + m) space
