import java.util.*;
import java.math.*;
public class Solution {
    public static void main(String [] args) {
        int index = 1;
        while (getNumOfDivisors(index * (index + 1) / 2) <= 500) {
            index++;
        }
        System.out.println(index * (index + 1) / 2);
    }
    public static int getNumOfDivisors(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                int times = 0;
                while (n % i == 0) {
                    n /= i;
                    times++;
                }
                res *= (times + 1);
            }
            if (n == 1) {
                break;
            }
        }
        return res;
    }
}
