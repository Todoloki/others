import java.io.*;
import java.util.*;

public class Mysample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long[] factorials = new long[10];
        factorials[0] = 1;
        long product = 1;
        long totalSum = 0;
        for (int i = 1; i < 10; i++) {
            product *= i;
            factorials[i] = product;
        }
        for (long i = 10; i < 100000000; i++) {
            long t = i;
            long sum = 0;
            while (t != 0) {
                int d = (int)(t % 10);
                t /= 10;
                sum += factorials[d];
            }
            if (sum == i) {
                totalSum += i;
            }
        }
        System.out.println(totalSum);
    }

}
// 0! = 1
