import java.util.*;
import java.math.*;
import java.io.*;

public class Mysample {
    public static void main(String [] args) {
        // brute force first
        // the value of coin that we need to get is 200
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(10);
        list.add(20);
        list.add(50);
        list.add(100);
        list.add(200);
        int[][] dp = new int[200 + 1][list.size() + 1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= 200; i++) {
            for (int j = 1; j <= list.size(); j++) {
                for (int k = 0; k <= i / list.get(j - 1); k++) {
                    dp[i][j] += dp[i - k * list.get(j - 1)][j - 1];
                }
            }
        }
        System.out.println(dp[200][list.size()]);
    }
}
// tabulation
