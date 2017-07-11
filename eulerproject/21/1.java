import java.util.*;
import java.math.*;
public class Solution {
    public static void main(String [] args) {
        int limit = 10000;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int res = 0;
        for (int i = 1; i <= limit; i++) {
            int sum = 0;
            for (int j = 1; j < i; j++) {
                if (j * j > i) {
                    break;
                }
                if (i % j == 0) {
                    if (i / j == j) {
                        sum += j;
                    }
                    else {
                        sum += j;
                        sum += i / j;
                    }
                }
            }
            sum -= i;
            if (map.containsKey(sum) && map.get(sum) == i) {
                res += sum;
                res += i;
            }
            map.put(i, sum);
            // System.out.println(i + " " + sum);
        }
        System.out.println(res);
    }
}
