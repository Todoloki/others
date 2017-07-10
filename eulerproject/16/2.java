import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        for (int i = 0; i < numOfCases; i++) {
            int power = scanner.nextInt();
            String res = getPower(power);
            int sum = 0;
            for (int j = 0; j < res.length(); j++) {
                sum += res.charAt(j) - '0';
            }
            System.out.println(sum);
        }
    }
    public static String getPower(int power) {
        if (power == 0) {
            return "1";
        }
        String half = getPower(power / 2);
        int[] product = new int[half.length() * 2 + 1];
        for (int i = 0; i < half.length(); i++) {
            for (int j = 0; j < half.length(); j++) {
                int d1 = half.charAt(half.length() - 1 - i) - '0';
                int d2 = half.charAt(half.length() - 1 - j) - '0';
                product[i + j] += d1 * d2;
            }
        }
        int c = 0;
        for (int i = 0; i < product.length; i++) {
            product[i] += c;
            c = product[i] / 10;
            product[i] %= 10;
        }
        if (power % 2 == 1) {
            c = 0;
            for (int i = 0; i < product.length; i++) {
                product[i] *= 2;
                product[i] += c;
                c = product[i] / 10;
                product[i] %= 10;
            }
        }
        int index = product.length - 1;
        while (index > 0 && product[index] == 0) {
            index--;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = index; i >= 0; i--) {
            sb.append(product[i]);
        }
        return sb.toString();
    }
}
