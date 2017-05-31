/**
 * Wanna play splatoon.
 */
import java.util.*;
public class Solution {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        double sum = 0;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        for (int i = 0; i < k - 1; i++) {
            sum += nums[i];
        }
        double res = 0;
        for (int i = k - 1; i < n; i++) {
            sum += nums[i];
            res += sum;
            sum -= nums[i - k + 1];
        }
        System.out.format("%.6f", res / (n - k + 1));
    }
}
/*
  from n numbers, get the average as k numbers as a week.

Method 1:
  get sum for all k numbers possible. That is, get sum for numbers in all (n - k + 1) weeks. Sum them up.
  And divide the sum by number of weeks. Time complexity O(n * k). Space complextiy, despite the array used for
  store all the numbers, only O(1) space is used.
Method 2:
  get the sum for all first k numbers. to calculate the sum for next week, just add the next number
  and minus the first number. we do this kind of operation to all weeks.
  After we get the sum for all (n - k + 1) weeks, we can calculate the average by divide it with the number of 
  weeks.
  Time complexity O(n). It is faster.
  Space complexity, only O(1) extra space is used.

  
  */
