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

        // since every third number is even
        int n1 = 1;
        int n2 = 1;
        int n3 = 0;
        int sum = 0;
        while (n3 <= 4000000) {
            n3 = n1 + n2;
            sum += n3;
            // odd
            n1 = n2 + n3;
            // odd
            n2 = n3 + n1;
            // even
            n3 = n1 + n2;
        }
        System.out.println(sum);
    }
}


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

        // since every third number is even
        int n1 = 1;
        int n2 = 2;
        int n3 = n1 + n2;
        int sum = 2;
        n1 = n2 + n3;
        n2 = n3 + n1;
        int temp = n3;
        n3 = n2;
        n2 = n1;
        n1 = temp;
        while (n3 <= 4000000) {
            n3 = n1 + n2;
            sum += n3;
            // odd
            n1 = n2 + n3;
            // odd
            n2 = n3 + n1;
            // even
            n3 = n1 + n2;
        }
        System.out.println(sum);
    }
}
