import java.util.*;
import java.math.*;
public class Solution {
    public static void main(String [] args) {
        // using combination

        // you can choose n out of 2 * n steps to be going down
        int limit = 20;
        long product = 1;
        for (int i = 1; i <= 20; i++) {
            product *= (41 - i);
            product /= i;
        }
        System.out.println(product);
    }
}
// O(n) time
// O(1) space
