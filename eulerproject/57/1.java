import java.io.*;
import java.util.*;
import java.math.*;

public class Mysample {
    public static void main(String[] args) {
        int[] numerator = new int[]{1};
        int[] denominator = new int[]{1};
        int counter = 0;
        for (int i = 1; i <= 1000; i++) {
            int[] newDenominator = add(numerator, denominator);
            int[] newNumerator = add(newDenominator, denominator);
            if (newNumerator.length > newDenominator.length) {
                counter++;
            }
            numerator = newNumerator;
            denominator = newDenominator;
        }
        System.out.println(counter);
    }
    public static int[] add(int[] num1, int[] num2) {
        int[] sum = new int[Math.max(num1.length, num2.length) + 1];
        int c = 0;
        for (int i = 0; i < sum.length; i++) {
            int s = (i < num1.length ? num1[i] : 0) + (i < num2.length ? num2[i] : 0) + c;
            c = s / 10;
            s %= 10;
            sum[i] = s;
        }
        int maxIndex = sum.length - 1;
        while (maxIndex > 0 && sum[maxIndex] == 0) {
            maxIndex--;
        }
        int[] res = new int[maxIndex + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = sum[i];
        }
        return res;
    }
}
