import java.util.*;
import java.math.*;
public class Solution {
    public static void main(String [] args) {
        int limit = 1000;
        int sum = 0;
        for (int i = 1; i <= limit; i++) {
            for (int j = 1; j <= limit; j++) {
                if (getSumOfDivisors(i) == j && getSumOfDivisors(j) == i) {
                    sum += i;
                }
            }
        }
        System.out.println(sum);
    }
    public static int getSumOfDivisors(int num) {
        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
// at most limit * limit of getSumOfDivisors() will be called
// time complexity limit * limit * limit;
