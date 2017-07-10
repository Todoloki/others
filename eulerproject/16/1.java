import java.util.*;
import java.math.*;
public class Solution {
    public static void main(String [] args) {
        int power = 1000;
        String res = getPower(power);
        int sum = 0;
        for (int i = 0; i < res.length(); i++) {
            sum += res.charAt(i) - '0';
        }
        System.out.println(sum);
    }
    public static String getPower(int power) {
        if (power == 0) {
            return "1";
        }
        String half = getPower(power / 2);
        int[] multiplication = new int[half.length() * 2 + 1];
        for (int i = 0; i < half.length(); i++) {
            for (int j = 0; j < half.length(); j++) {
                int d1 = half.charAt(half.length() - 1 - i) - '0';
                int d2 = half.charAt(half.length() - 1 - j) - '0';
                multiplication[i + j] += d1 * d2;
            }
        }
        int c = 0;
        for (int i = 0; i < multiplication.length; i++) {
            multiplication[i] += c;
            c = multiplication[i] / 10;
            multiplication[i] %= 10;
        }
        if (power % 2 == 1) {
            c = 0;
            for (int i = 0; i < multiplication.length; i++) {
                multiplication[i] *= 2;
                multiplication[i] += c;
                c = multiplication[i] / 10;
                multiplication[i] %= 10;
            }
        }
        int index = multiplication.length - 1;
        while (index > 0 && multiplication[index] == 0) {
            index--;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = index; i >= 0; i--) {
            sb.append(multiplication[i]);
        }
        return sb.toString();
    }
}
