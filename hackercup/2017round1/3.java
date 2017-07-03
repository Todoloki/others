import java.util.*;
public class Solution {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        for (int i = 0; i < numOfCases; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] distance = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int t = 0; t < n; t++) {
                    distance[j][t] = -1;
                }
            }
            for (int j = 0; j < n; j++) {
                distance[j][j] = 0;
            }
            for (int j = 0; j < m; j++) {
                int city1 = scanner.nextInt() - 1;
                int city2 = scanner.nextInt() - 1;
                int gas = scanner.nextInt();
                if (distance[city1][city2] == -1) {
                    distance[city1][city2] = gas;
                }
                else {
                    distance[city1][city2] = Math.min(distance[city1][city2], gas);
                }
                distance[city2][city1] = distance[city1][city2];
            }
            for (int t1 = 0; t1 < n; t1++) {
                for (int t2 = 0; t2 < n; t2++) {
                    for (int t3 = 0; t3 < n; t3++) {
                        int edge1 = distance[t1][t2];
                        int edge2 = distance[t1][t3];
                        if (edge1 >= 0 && edge2 >= 0) {
                            int edge3 = distance[t2][t3];
                            if (edge3 == -1 || edge1 + edge2 < edge3) {
                                distance[t2][t3] = edge1 + edge2;
                            }
                        }
                    }
                }
            }
            List<int[]> tasks = new ArrayList<int[]>();
            for (int t1 = 0; t1 < k; t1++) {
                tasks.add(new int[]{scanner.nextInt(), scanner.nextInt()});
            }
            int[][][] dp = new int[k + 1][n][3];
            for (int t1 = 0; t1 < k + 1; t1++) {
                for (int t2 = 0; t2 < n;  t2++) {
                    for (int t3 = 0; t3 < 3; t3++) {
                        dp[t1][t2][t3] = -1;
                    }
                }
            }
            for (int t1 = 0; t1 <= k; t1++) {
                for (int t3 = 0; t3 < 3; t3++) {
                    for (int t2 = 0; t2 < n;  t2++) {
                        if (t1 == 0 && t3 == 0) {
                            dp[t1][t2][t3] = 0;
                            continue;
                        }
                        if (t1 == 0) {
                            if (t3 == 1) {
                                int city1 = t2;
                                int city3 = tasks.get(tasks.size() - 1)[1] - 1;
                                if (distance[city1][city3] >= 0) {
                                    dp[t1][t2][t3] = distance[city1][city3];
                                }
                            }
                            else {
                                int city1 = t2;
                                if (tasks.size() < 2) {
                                    continue;
                                }
                                int city2 = tasks.get(tasks.size() - 2)[1] - 1;
                                int city3 = tasks.get(tasks.size() - 1)[1] - 1;
                                if (distance[city1][city2] >= 0 && distance[city2][city3] >= 0) {
                                    dp[t1][t2][t3] = distance[city1][city2] + distance[city2][city3];
                                }
                            }
                            continue;
                        }
                        if (t3 == 0) {
                            int index = k - t1;
                            int city1 = t2;
                            int city2 = tasks.get(index)[0] - 1;
                            if (distance[city1][city2] >= 0 && dp[t1 - 1][city2][1] >= 0) {
                                dp[t1][t2][t3] = distance[city1][city2] + dp[t1 - 1][city2][1];
                            }
                            continue;
                        }
                        if (t3 == 2) {
                            int index = k - t1 - 2;
                            int city1 = t2;
                            int city2 = index >= 0 ? tasks.get(index)[1] - 1 : -1;
                            if (city2 >= 0 && distance[city1][city2] >= 0 && dp[t1][city2][1] >= 0) {
                                dp[t1][t2][t3] = distance[city1][city2] + dp[t1][city2][1];
                            }
                            continue;
                        }
                        int city1 = t2;
                        int index1 = k - t1;
                        int city2 = index1 >= 0 ? tasks.get(index1)[0] - 1 : -1;
                        int min = -1;
                        if (city2 >= 0 && distance[city1][city2] >= 0 && dp[t1 - 1][city2][2] >= 0) {
                            min = distance[city1][city2] + dp[t1 - 1][city2][2];
                        }
                        int index2 = k - t1 - 1;
                        int city3 = index2 >= 0 ? tasks.get(index2)[1] - 1 : -1;
                        if (city3 >= 0 && distance[city1][city3] >= 0 && dp[t1][city3][0] >= 0) {
                            if (min == -1 || min > dp[t1][city3][0] + distance[city1][city3]) {
                                min = dp[t1][city3][0] + distance[city1][city3];
                            }
                        }
                        dp[t1][t2][t3] = min;
                    }
                }
            }
            System.out.print("Case #" + (i + 1) + ": ");
            System.out.println(dp[k][0][0]);
        }
    }
}
// O(n*n*n) to precompute shortest road between any two node (floyd-Warshall algorithm)
// O(k * n) time to fill all the blanks in this table
// use tabulation
// memoizatation will result as stack overflow
// be careful that there can be multiple road between two city and we need to find the minimum one
// O(k*n) extra space used to do the tabulation.
