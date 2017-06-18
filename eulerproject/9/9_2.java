/**
 * Wanna play splatoon.
 */
import java.util.*;
public class Solution {
    public static void main(String [] args) {
        int sum = 1000;
        for (int i = 1; i <= 1000; i++) {
            for (int j = i + 1; j < 1000 - i; j++) {
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
// straightforward approach
// O(n * n) time
