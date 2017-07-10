import java.util.*;
import java.math.*;
public class Solution {
    public static void main(String [] args) {
        System.out.println(getNumberOfWays(2, 2));
    }
    public static int getNumberOfWays(int x, int y) {
        if (x == 0 && y == 0) {
            return 1;
        }
        int sum = 0;
        if (x > 0) {
            sum += getNumberOfWays(x - 1, y);
        }
        if (y > 0) {
            sum += getNumberOfWays(x, y - 1);
        }
        return sum;
    }
}
// recursion using.
