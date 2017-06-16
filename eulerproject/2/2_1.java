import java.util.*;
public class Solution {
    public static void main(String [] args)
    {
        // since the next even fibonacci number should be at least two times of the current even fibonacci number
        // so the number of fibonacci number that is odd and less than 4 million is limited
        // 4 million is like 4,000,000 which is within Integer's range for Java

        // brute force
        long n1 = 1;
        long n2 = 2;
        long sum = 2;
        long n3 = 0;
        while (n3 <= 4000000) {
            n3 = n1 + n2;
            if (n3 % 2 == 0) {
                sum += n3;
            }
            n1 = n2;
            n2 = n3;
        }
        System.out.println(sum);
    }
}
