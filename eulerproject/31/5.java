import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        long[] dp = new long[100000 + 1];
        dp[0] = 1;
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(10);
        list.add(20);
        list.add(50);
        list.add(100);
        list.add(200);
        for (int i = 0; i < list.size(); i++) {
            for (int j = list.get(i); j <= 100000; j++) {
                dp[j] += dp[j - list.get(i)];
                dp[j] %= 1000000007;
            }
        }
        for (int i = 0; i < numOfCases; i++) {
            int number = scanner.nextInt();
            System.out.println(dp[number]);
        }
    }
}
// passed hackerrank
