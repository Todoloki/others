import java.util.*;
import java.math.*;
public class Solution {
    public static void main(String [] args) {
        // m * n the product will not exceed
        // 3 + 90 * 2 + 1 * 9 = 3 + 180 + 9
        // 200 digits should be enough
        int[] number = new int[200];
        // store the digits of the product in reverse position, that means
        // the most dominent digit lies at the end of the array
        // or the last digit lies at the first of the array

        number[0] = 1;
        for (int i = 2; i <= 100; i++) {
            int c = 0;
            for (int j = 0; j < number.length; j++) {
                number[j] *= i;
                number[j] += c;
                c = number[j] / 10;
                number[j] %= 10;
            }
        }
        int sum = 0;
        for (int i = 0; i < number.length; i++) {
            sum += number[i];
        }
        System.out.println(sum);
    }
}
