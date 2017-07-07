import java.util.*;
import java.math.*;
public class Solution {
    public static void main(String [] args) {
        int limit = 5;
        int n = 1;
        int curNumber = 1;
        int counter = 1;
        while (counter <= limit) {
            curNumber++;
            n += curNumber;
            counter = 0;
            int maxDivisor = (int)Math.floor(Math.sqrt(n));
            for (int i = 1; i <= maxDivisor; i++) {
                if (n % i == 0) {
                    counter++;
                }
            }
            counter *= 2;
            if (maxDivisor * maxDivisor == n) {
                counter--;
            }
        }
        System.out.println(n);
    }
}
// instead of checking every number below the trianguler number is a divisor
// check until square root of it, because for every divisor less than the squre root there is a divisor that is larger than the square
// root.
