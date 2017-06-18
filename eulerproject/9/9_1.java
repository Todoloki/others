/**
 * Wanna play splatoon.
 */
import java.util.*;
public class Solution {
    public static void main(String [] args) {
        int sum = 1000;
        // a, b, c are natural numbers
        int max = (int) Math.floor(Math.sqrt(sum));

        // a * a + b * b = c * c
        // 2ab = 1000000 - 2000c
        for (int i = 1; i <= 1000; i++) {
            for (int j = i + 1; j <= 1000; j++) {
                int target = 1000000 - 2 * i * j;
                if (target % 2000 != 0) {
                    continue;
                }
                else {
                    target /= 2000;
                    if (target <= j) {
                        continue;
                    }
                    if (target <= 1000 && i * i + j * j == target * target) {
                        //System.out.println(i + " " + j + " " + target);
                        System.out.println(i * j * target);
                    }
                }
            }
        }
    }
}

// time O(n*n)
