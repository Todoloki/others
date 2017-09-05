import java.io.*;
import java.util.*;
import java.math.*;

public class Mysample {
    public static void main(String[] args) {
        int max = 0;
        for (int a = 1; a < 100; a++) {
            int[] num = new int[201];
            int temp = a;
            int index = 0;
            while (temp != 0) {
                num[index++] = temp % 10;
                temp /= 10;
            }
            int[] product = new int[]{1};
            for (int b = 1; b < 100; b++) {
                product = getProduct(product, num);
                int sum = 0;
                for (int i = 0; i < product.length; i++) {
                    sum += product[i];
                }
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }
    public static int[] getProduct(int[] num1, int[] num2) {
        int[] res = new int[num1.length + num2.length];
        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num2.length; j++) {
                res[i + j] += num1[i] * num2[j];
            }
        }
        int carry = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] += carry;
            carry = res[i] / 10;
            res[i] %= 10;
        }
        int maxIndex = res.length - 1;
        while (maxIndex > 0 && res[maxIndex] == 0) {
            maxIndex--;
        }
        int[] product = new int[maxIndex + 1];
        for (int i = 0; i < product.length; i++) {
            product[i] = res[i];
        }
        return product;
    }
}
