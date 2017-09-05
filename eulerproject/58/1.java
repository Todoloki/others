import java.io.*;
import java.util.*;
import java.math.*;

public class Mysample {
    public static void main(String[] args) {
        int counter = 9;
        int side = 3;
        int numOfPrimes = 3;
        double percent = (0.0 + numOfPrimes) / (side / 2 * 4 + 1);
        while (percent >= 0.1) {
            int num1 = counter + (side + 1);
            int num2 = num1 + (side + 1);
            int num3 = num2 + (side + 1);
            int num4 = num3 + (side + 1);
            side += 2;
            counter = num4;
            if (isPrime(num1)) {
                numOfPrimes++;
            }
            if (isPrime(num2)) {
                numOfPrimes++;
            }
            if (isPrime(num3)) {
                numOfPrimes++;
            }
            if (isPrime(num4)) {
                numOfPrimes++;
            }
            percent = (0.0 + numOfPrimes) / (side / 2 * 4 + 1);
            // System.out.println(side + " " + percent + " " + numOfPrimes);
        }
        System.out.println(side);
    }
    public static boolean isPrime(int num) {
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        int factor = 6;
        while (factor - 1 <= (int)Math.floor(Math.sqrt(num))) {
            if (num % (factor - 1) == 0) {
                return false;
            }
            if (num % (factor + 1) == 0) {
                return false;
            }
            factor += 6;
        }
        return true;
    }
}
