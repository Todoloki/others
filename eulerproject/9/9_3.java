/**
 * Wanna play splatoon.
 */
import java.util.*;
public class Solution {
    public static void main(String [] args) {

        // for a < 1000 / 3
        // since 1000 % 3 != 0
        // so a <= 1000 / 3

        // since 1000 % 2 == 0
        // so b < 1000 / 2 && b > a


        int sum = 1000;
        for (int i = 1; i <= 1000; i++) {
            for (int j = i + 1; j < 1000 / 2; j++) {
                //for (int k = j + 1; k <= 1000; k++) {
                int k = 1000 - i - j;
                    if (i * i + j * j == k * k) {
                        //System.out.println(i + " " + j + " " + k);
                        System.out.println(i * j * k);
                    }
                //}
            }
        }
    }
}
