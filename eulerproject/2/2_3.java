/**
 * Wanna play splatoon.
 */
import java.util.*;
public class Solution {
    public static void main(String [] args)
    {
        // since the next even fibonacci number should be at least two times of the current even fibonacci number
        // so the number of fibonacci number that is odd and less than 4 million is limited
        // 4 million is like 4,000,000 which is within Integer's range for Java

        // Prove that F(n) = F(n - 1) + F(n - 2)
        // So that F(n) = 4 * F(n - 3) + F(n - 6)
        // F(n) = F(n - 1) + F(n - 2)
        //      = F(n - 2) + F(n - 3) + F(n - 2)
        //      = 2 * F(n - 2) + F(n - 3)
        //      = 2 * (F(n - 3) + F(n - 4)) + F(n - 4) + F(n - 5)
        //      = 2 * (F(n - 3) + F(n - 4)) + F(n - 5) * 2 + F(n - 6)
        //      = 4 * F(n - 3) + F(n - 6)

        long e1 = 2;
        long e2 = 8;
        long e3 = 34;
        long sum = e1 + e2;
        while (e3 <= 4000000) {
            sum += e3;
            e1 = e2;
            e2 = e3;
            e3 = 4 * e2 + e1;
        }
        System.out.println(sum);
    }
}
