import java.util.*;
import java.math.*;
import java.io.*;

public class Mysample {
    public static void main(String [] args) {
        int limit = 1000 * 1000 + 1000 * 1000 + 1000;
        boolean[] isNotPrime = new boolean[(limit - 1) / 2 + 1];
        for (int i = 1; i < isNotPrime.length; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            if (2 * i + 1 > (int) Math.floor(Math.sqrt(isNotPrime.length - 1)) * 2 + 1) {
                break;
            }
            for (int j = ((2 * i + 1) * (2 * i + 1) - 1) / 2; j < isNotPrime.length; j += 2 * i + 1) {
                isNotPrime[j] = true;
            }
        }
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(2);
        for (int i = 1; i < isNotPrime.length; i++) {
            if (isNotPrime[i] == false) {
                set.add(2 * i + 1);
            }
        }
        int maxCounter = 0;
        int resA = 0;
        int resB = 0;
        for (int i = -999; i <= 999; i++) {
            for (int j = -1000; j <= 999; j++) {
                int start = 0;
                int counter = 0;
                int curNumber = start * start + start * i + j;
                while (set.contains(curNumber)) {
                    counter++;
                    start++;
                    curNumber = start * start + start * i + j;
                }
                if (counter > maxCounter) {
                    maxCounter = counter;
                    resA = i;
                    resB = j;
                }
            }
        }
        System.out.println(resA + " " + resB + " " + resA * resB);
    }
}
