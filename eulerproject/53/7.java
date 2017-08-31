import java.io.*;
import java.util.*;
import java.math.*;

public class Mysample {
    public static void main(String[] args) {
        int[][] factorials = new int[101][101];
        factorials[0][0] = 1;
        int counter = 0;
        for (int i = 1; i <= 100; i++) {
            factorials[i][0] = 1;
            for (int j = 1; j < i; j++) {
                factorials[i][j] = factorials[i - 1][j] + factorials[i - 1][j - 1];
                if (factorials[i][j] > 1000000) {
                    factorials[i][j] = 1000000;
                    counter++;
                }
            }
            factorials[i][i] = 1;
        }
        System.out.println(counter);
    }
}
// avoid overflow
