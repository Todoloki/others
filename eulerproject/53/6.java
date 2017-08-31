import java.io.*;
import java.util.*;
import java.math.*;

public class Mysample {
    public static void main(String[] args) {
        BigInteger[][] factors = new BigInteger[101][101];
        factors[0][0] = new BigInteger("" + 1);
        BigInteger limit = new BigInteger("" + 1000000);
        int counter = 0;
        for (int i = 1; i <= 100; i++) {
            factors[i][0] = new BigInteger("" + 1);
            for (int j = 1; j < i; j++) {
                factors[i][j] = factors[i - 1][j].add(factors[i - 1][j - 1]);
                if (factors[i][j].compareTo(limit) > 0) {
                    counter++;
                }
            }

            factors[i][i] = new BigInteger("" + 1);
        }
        System.out.println(counter);
    }
}
// use c(n, r) = c(n - 1, r) + c(n - 1, r - 1)
