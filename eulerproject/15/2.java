import java.util.*;
import java.math.*;
public class Solution {
    public static void main(String [] args) {
        HashMap<String, Long> map = new HashMap<String, Long>();
        System.out.println(getNumberOfWays(20, 20, map));
    }
    public static long getNumberOfWays(int x, int y, HashMap<String, Long> map) {
        String key = x + " " + y;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (x == 0 && y == 0) {
            return 1;
        }
        long sum = 0;
        if (x > 0) {
            sum += getNumberOfWays(x - 1, y, map);
        }
        if (y > 0) {
            sum += getNumberOfWays(x, y - 1, map);
        }
        map.put(key, sum);
        return sum;
    }
}
// recursion and memoizatation
// from 2 ^ (m + n) to (m + n) ^ 2 for time
// from m + n to (m + n) ^ 2 for space.
