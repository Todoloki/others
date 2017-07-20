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
        int[] dp = new int[201];
        dp[0] = 1;
        for (int i = 0; i < list.size(); i++) {
            for (int j = list.get(i); j <= 200; j++) {
                dp[j] += dp[j - list.get(i)];
            }
        }
        System.out.println(dp[200]);
    }
}
// for every value, we can use this value many times
