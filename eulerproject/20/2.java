import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        for (int i = 0; i < numOfCases; i++) {
            int n = scanner.nextInt();
            if (n == 0) {
                System.out.println(1);
                continue;
            }
            int[] numbers = new int[3000];
            numbers[0] = 1;
            for (int j = 2; j <= n; j++) {
                int c = 0;
                for (int k = 0; k < numbers.length; k++) {
                    numbers[k] *= j;
                    numbers[k] += c;
                    c = numbers[k] / 10;
                    numbers[k] %= 10;
                }
            }
            int sum = 0;
            for (int j = 0; j < numbers.length; j++) {
                sum += numbers[j];
            }
            System.out.println(sum);
        }
    }
}
// 0! = 1
