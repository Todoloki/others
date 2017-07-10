import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        int[] sums = new int[50 + 3];
        for (int i = 0; i < numOfCases; i++) {
            String s = scanner.next();
            for (int j = 0; j < 50; j++) {
                sums[49 - j] += s.charAt(j) - '0';
            }
        }
        int c = 0;
        for (int i = 0; i < sums.length; i++) {
            sums[i] += c;
            c = sums[i] / 10;
            sums[i] %= 10;
        }
        int index = 52;
        while (index > 0 && sums[index] == 0) {
            index--;
        }
        for (int i = index; i >= index - 9; i--) {
            System.out.print(sums[i]);
        }
    }
}
// passed hackerrank
