import java.util.*;
import java.math.*;
public class Solution {
    public static void main(String [] args) {
        int limit = 1000;
        int sum = 0;
        for (int i = 1; i < limit; i++) {
            for (int j = i + 1; j < limit; j++) {
                int sumOfI = getSumOfDivisor(i);
                int sumOfJ = getSumOfDivisor(j);
                if (sumOfI == j && sumOfJ == i) {
                    sum += i;
                    sum += j;
                }
            }
        }
        // System.out.println(getSumOfDivisor(220));
        // System.out.println(getSumOfDivisor(284));
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
// still O(limit ^ 2 * sqrt(limit)) but cost only half the time 2.java cost.
// O(1) space
