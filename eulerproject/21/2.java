import java.util.*;
import java.math.*;
public class Solution {
    public static void main(String [] args) {
        int limit = 100;
        int sum = 0;
        for (int i = 1; i < limit; i++) {
            for (int j = 1; j < limit; j++) {
                int sumOfI = getSumOfDivisor(i);
                int sumOfJ = getSumOfDivisor(j);
                if (sumOfI == j && sumOfJ == i) {
                    sum += i;
                }
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
// getSumOfDivisor cost O(limit) time
// at most limit * limit * 2 times of this method will be called
// O(limit ^ 3) time
// O(1) space
