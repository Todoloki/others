import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] factorials = new int[10];
        factorials[0] = 1;
        int product = 1;
        for (int i = 1; i <= 9; i++) {
            product *= i;
            factorials[i] = product;
        }
        int totalSum = 0;
        for (int i = 10; i < N; i++) {
            int t = i;
           int sum = 0;
            while (t != 0) {
                int d = t % 10;
                t /= 10;
                sum += factorials[d];
                sum %= i;
               
            }
            if (sum == 0) {
                totalSum += i;
            }
        }
        System.out.println(totalSum);
    }
}

// passed hackerrank
