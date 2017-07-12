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
        for (int i = 1; i <= num; i++) {
            if (i * i > num) {
                break;
            }
            if (num % i == 0) {
                if (num % i == i) {
                    sum += i;
                }
                else {
                    sum += i;
                    sum += num / i;
                }
            }
        }
        sum -= num;
        return sum;
    }
}
// cost only O(limit ^ 2) time
