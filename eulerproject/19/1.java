import java.util.*;
import java.math.*;
public class Solution {
    public static void main(String [] args) {
        int cur = 1;
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int counter = 0;
        for (int i = 1900; i <= 2000; i++) {
            for (int j = 0; j < days.length; j++) {
                if (i >= 1901 && cur == 0) {
                    counter++;
                }
                if (((i % 100 != 0 && i % 4 == 0) || (i % 400 == 0)) && j == 1) {
                    cur += 29;
                }
                else {
                    cur += days[j];
                }
                cur %= 7;
            }
        }
        System.out.println(counter);
    }
}
