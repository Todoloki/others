/**
 * Wanna play splatoon.
 */
import java.util.*;
public class Solution {
    public static void main(String [] args)
    {
        int N = 10;
        int sum = 0;
        for (int i = 1; i < N; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
// calculate the sum for all natural numbers below N
// Method 1:
// check if every natural number below N is dividable by 3 or 5, if it is, calculate the sum.
// Time complexity O(N)

// Method 2:
// Calculate the sum for all natural numbers dividable by 5
// calculate the sum for all natural numbers dividable by 3
// sum up the dividables for 3 and 5 minus the sum of dividables by 15
/**
 * Wanna play splatoon.
 */
import java.util.*;
public class Solution {
    public static void main(String [] args)
    {
        int N = 1000;
        N--;
        int num3 = N / 3;
        int num5 = N / 5;
        int num15 = N / 15;
        int s3 = num3 == 0 ? 0 : (1 + num3) * num3 / 2 * 3;
        int s5 = num5 == 0 ? 0 : (1 + num5) * num5 / 2 * 5;
        int s15 = num15 == 0 ? 0 : (1 + num15) * num15 / 2 * 15;
        System.out.println(s3 + s5 - s15);
    }
}
// Time complexity O(1)


