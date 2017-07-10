import java.util.*;
import java.math.*;
public class Solution {
    public static void main(String [] args) {
        int limit = 1000000;
        int[] steps = new int[1000001];
        int max = 0;
        int maxNumber = 1;
        for (int i = 2; i <= 1000000; i++) {
            int step = 0;
            long temp = i;
            while (temp != 1) {
                if (temp <= 1000000 && steps[(int)temp] != 0) {
                    step += steps[(int)temp];
                    break;
                }
                if (temp % 2 == 0) {
                    temp /= 2;
                }
                else {
                    temp *= 3;
                    temp += 1;
                }
                step++;
            }
            if (step > max) {
                max = step;
                maxNumber = i;
            }
        }
        System.out.println(maxNumber);
    }
}
