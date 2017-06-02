// this problem gives you an array with positive numbers.
// you need to make one move to make the array to be equal divided at some point
// sum all elements
// start from left to right sum all elements occurred and when the sum for occured elements is larger than half the total sum, search
// to find if the difference between total sum and occurred elements exist.
// conner case if total sum is odd, it is impossible
// be careful because you should also consider to move the element from right to left, so scanning from right to left is 
// also necessary.

// Time complexity O(n)
// space complexity O(n) for hashmap

// if just do the search
// time complexity O(n)
// space complexity O(nlogn) assument heap is used for search for the element

/**
 * Wanna play splatoon.
 */
import java.util.*;
public class Solution {
    public static void main(String [] args)
    {
        // read the elements
        // start from left to right
        // record the elements we have already encountered
        // scan the array from left to right, when the sum fo all elements scanned is larger than sum of
        // all elements divided by 2, then search for the difference in the elements we have already encountered
        // if we can find such an element, we can make the move, otherwise we can not
        // since move one element to its original position is considered valid, so if the sum of elements
        // we have already encountered is equal to the sum of all elements divided by 2, then it is valid.
        Scanner scanner = new Scanner(System.in);
        // here, read all the elements
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        // here parse the array and try to find if it is possible to make one move and divide them into two parts
        // contains elements which have equal sum.
        // conner case the sum of all the elements can not be odd.
        HashSet<Long> set = new HashSet<Long>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        if (sum % 2 == 1) {
            System.out.println("NO");
            return ;
        }
        long curSum = 0;
        for (int i = 0; i < n; i++) {
            curSum += a[i];
            set.add(a[i]);
            if (curSum == sum / 2) {
                System.out.println("YES");
                return ;
            }
            if (curSum > sum / 2) {
                long difference = curSum - sum / 2;
                //System.out.println(difference);
                if (set.contains(difference)) {
                    System.out.println("YES");
                    return ;
                }
            }
        }
        curSum = 0;
        set.clear();
        for (int i = n - 1; i >= 0; i--) {
            curSum += a[i];
            set.add(a[i]);
            if (curSum == sum / 2) {
                System.out.println("YES");
                return ;
            }
            if (curSum > sum / 2) {
                long difference = curSum - sum / 2;
                //System.out.println(difference);
                if (set.contains(difference)) {
                    System.out.println("YES");
                    return ;
                }
            }
        }
        System.out.println("NO");
    }
}
