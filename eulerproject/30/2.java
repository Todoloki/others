import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int numOfDigits = scanner.nextInt();
        int t = numOfDigits;
        int max = 10;
        while (t-- != 0) {
            max *= 10;
        }
        long sum = 0;
        for (int i = 10; i < max; i++) {
            int curNumber = i;
            int sumOfDigitsPower5 = 0;
            while (curNumber != 0) {
                int curDigit = curNumber % 10;
                int product = 1;
                for (int j = 0; j < numOfDigits; j++) {
                    product *= curDigit;
                }
                sumOfDigitsPower5 += product;
                curNumber /= 10;
            }
            if (sumOfDigitsPower5 == i) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
// passed hacker rank
// O(10 ^ N)

// if calculate all digits first
// get all permutations of such number of digits will cost O(n ^ 4)
// much faster
