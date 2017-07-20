import java.util.*;
import java.math.*;
import java.io.*;

public class Mysample {
    public static void main(String [] args) {
        int power = 5;
        long sum = 0;
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i <= 9; i++) {
            int product = 1;
            for (int j = 0; j < power; j++) {
                product *= i;
            }
            list.add(product);
        }

        for (int length = 2; length <= power + 1; length++) {
            sum = getAllNumber(sum, length, 0, list, 0, 0, true);
        }
        System.out.println(sum);
    }
    public static long getAllNumber(long sum, int targetLength, int curLength, List<Integer> list, int sum1, int sum2, boolean isFirstDigit) {
        if (curLength == targetLength) {
            if (sum1 == sum2)
                sum += sum1;
            return sum;
        }
        if (isFirstDigit) {
            for (int i = 1; i < list.size(); i++) {
                sum = getAllNumber(sum, targetLength, curLength + 1, list, sum1 * 10 + i, sum2 + list.get(i), false);
            }
        }
        else {
            for (int i = 0; i < list.size(); i++) {
                sum = getAllNumber(sum, targetLength, curLength + 1, list, sum1 * 10 + i, sum2 + list.get(i), false);
            }
        }
        return sum;
    }
}
// hima nanode
