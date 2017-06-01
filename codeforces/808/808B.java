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
Method 3:
    We can know that for every number in this array, the times it appeared in the arrray is Min(i + 1, n - i, k, n - i + 1) where
    i is in range 0 to n - 1. So we just add all of them in this way. But we need to be careful because the question asked for
    n, k in range 0 to 2 ^ 5. And each number in range 0 to 10 ^ 5, so when we do multiplication we can not use integer since the maximum
    number of integer is less than 3 * 10 ^ 9 but we can encounter the multiplication up to more than 2 * 10 ^ 10. 
    We need to always be careful of the range and also the precision of double.
    There's a long way to go. With my favourite Zelda- The breath of the wild.
  
  */
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
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        double sum = 0;
        for (int i = 0; i < n; i++) {
            int min1 = i + 1;
            int min2 = n - i;
            int min3 = Math.min(k, n - k + 1);
            min3 = Math.min(min1, min3);
            min3 = Math.min(min3, min2);
            sum += ((double)min3) *  nums[i];
        }
        System.out.format("%.6f", sum / (n - k + 1));
    }
}

