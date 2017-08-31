import java.io.*;
import java.util.*;
import java.math.*;

public class Mysample {
    public static void main(String[] args) {
        BigInteger[] factors = new BigInteger[101];
        for (int i = 0; i <= 100; i++) {
            factors[i] = getFactor(i);

        }
        BigInteger limit = new BigInteger("" + 1000000);
        int counter = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= i; j++) {
                BigInteger combination = factors[i].divide(factors[j]);
                combination = combination.divide(factors[i - j]);
                if (combination.compareTo(limit) > 0) {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
    public static BigInteger getFactor(int i) {
        BigInteger res = new BigInteger("" + 1);
        for (int j = 2; j <= i; j++) {
            BigInteger multiplier = new BigInteger("" + j);
            res = res.multiply(multiplier);
        }
        return res;
    }
}
// since we will calculate the factorial of a number repeatedly, so pre-calculate is possible.
