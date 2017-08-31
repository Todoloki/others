import java.io.*;
import java.util.*;
import java.math.*;

public class Mysample {
    public static void main(String[] args) {
        int counter = 0;
        BigInteger limit = new BigInteger("" + 1000000);
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= i; j++) {
                BigInteger fi = getFactor(i);
                BigInteger fj = getFactor(j);
                BigInteger fimj = getFactor(i - j);
                BigInteger res = fi.divide(fj);
                res = res.divide(fimj);
                if (res.compareTo(limit) > 0) {
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
// first method in the pdf file.
