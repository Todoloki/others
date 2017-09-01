import java.io.*;
import java.util.*;
import java.math.*;

public class Mysample {
    public static void main(String[] args) {
        int[] factorials = new int[101];
        factorials[0] = 1;
        int counter = 0;
        int limit = 1000000;

        for (int i = 1; i <= 100; i++) {
            for (int j = i - 1; j >= 1; j--) {
                factorials[j] = factorials[j] + factorials[j - 1];
                if (factorials[j] > limit) {
                    factorials[j] = limit;
                    counter++;
                }
            }
            factorials[i] = 1;
        }

        System.out.println(counter);
    }
}
// use 1D array instead of 2D array
