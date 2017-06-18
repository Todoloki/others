import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            String num = in.next();
            long max = 0;
            for (int i = 0; i < n - k + 1; i++) {
                long product = 1;
                for (int j = 0; j < k; j++) {
                    product *= num.charAt(i + j) - '0';
                }
                max = Math.max(max, product);
            }
            System.out.println(max);
        }
    }
}

// maybe brute force is enough
// I can't think of a more efficient way to solve this problem.
// And there is no such pdf file that explains a more efficient way.
// maybe there will be no pdf files in the future
// you never know
// zelda still busy solving puzzles, happy!
// dlc will come out this month!
