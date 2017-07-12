import java.util.*;
import java.math.*;
public class Solution {
    public static void main(String [] args) {
        int limit = 10000;
        int sum = 0;
        for (int i = 1; i < limit; i++) {
            int sumOfI = getSumOfDivisor(i);
            if (sumOfI > i && getSumOfDivisor(sumOfI) == i) {
                sum += i;
                sum += sumOfI;
            }
        }
        System.out.println(sum);
    }
    public static int getSumOfDivisor(int num) {
        int sum = 0;
        if (num == 1) {
            return 0;
        }
        int max = (int) Math.floor(Math.sqrt(num));
        if (max * max == num) {
            return 1 + max;
        }
        sum = 1;
        int cur = 0;
        int step = 0;
        if (num % 2 == 0) {
            cur = 2;
            step = 1;
        }
        else {
            cur = 3;
            step = 2;
        }
        while (cur <= max) {
            if (num % cur == 0) {
                sum += cur;
                sum += num / cur;
            }
            cur += step;
        }
        return sum;
    }
}
// rewrite the getSumOfDivisors() method to make it to run more quickly.
