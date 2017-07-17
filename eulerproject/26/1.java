import java.util.*;
import java.math.*;
import java.io.*;

public class Mysample {
    public static void main(String [] args) {
        int limit = 1000;
        int maxRecycle = 0;
        int res = 0;
        // calculate the value for next digit
        // if we occur a case where the value we use as dividend is same
        // then we can be sure that we get into a cycle

        // since we need to calculate 1 / n
        // start from 1,
        // check if the remainder exist, if this remainder appears before, a cycle exist
        // calculate the length of the cycle

        // each time we multiply the remainder with 10
        // calculate the next digit for decimal as the result of 1 / n
        // calculate the remainder again

        // after calculating the length of cycle for all numbers below limit
        // we can know the maximum length of the cycle for 1 / n under 1000

        for (int cur = 2; cur < limit; cur++) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            int dividend = 10;
            int curLength = 0;
            while (dividend != 0) {
                if (map.containsKey(dividend)) {
                    int formerLength = map.get(dividend);
                    // System.out.println(cur + " " + (curLength - formerLength));
                    if (maxRecycle < curLength - formerLength) {
                        maxRecycle = curLength - formerLength;
                        res = cur;
                    }
                    break;
                }
                map.put(dividend, curLength);
                dividend %= cur;
                curLength++;
                dividend *= 10;
            }
        }
        System.out.println(res);
    }
}
