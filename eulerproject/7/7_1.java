/**
 * Wanna play splatoon.
 */
import java.util.*;
public class Solution {
    public static void main(String [] args)
    {
        int maxSize = 10001;
        List<Long> list = new ArrayList<Long>();
        long curNum = 2;
        while (list.size() < maxSize) {
            boolean isPrime = true;
            for (int i = 0; i < list.size(); i++) {
                if (curNum % list.get(i) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                list.add(curNum);
            }
            curNum++;
        }
        System.out.println(list.get(maxSize - 1));
    }
}
// O(n) space and O(n * n)time
