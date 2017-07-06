import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        int limit = 0;
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            list.add(n);
            limit = Math.max(limit, n);
        }
        boolean[] isNotPrime = new boolean[(limit - 1) / 2 + 1];
        long[] nums = new long[isNotPrime.length];
            for (int i = 1; i <= ((int) Math.floor(Math.sqrt(limit)) - 1) / 2; i++) {
                if (isNotPrime[i]) {
                    continue;
                }
                for (int j = 2 * i * (i + 1); j < isNotPrime.length; j += 2 * i + 1) {
                    isNotPrime[j] = true;
                }
            }
            long sum = 2;
        nums[0] = 2;
            for (int i = 1; i < isNotPrime.length; i++) {
                if (isNotPrime[i] == false) {
                    sum += 2 * i + 1;
                }
                nums[i] = sum;
            }
       for (int i = 0; i < list.size(); i++) {
           int n = list.get(i);
           if (n == 1) {
               System.out.println(0);
           }
           else {
               System.out.println(nums[(n - 1) / 2]);
           }
       }
    }
}


// passed hackerrank
// the difference is that instead of calculating for every number, we calculate just for maximum nubmer and get the
// others using the middle result.
