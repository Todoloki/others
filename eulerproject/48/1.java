import java.io.*;
import java.util.*;

public class Mysample {
    public static void main(String[] args) {
        long sum = 0;
        long modNumber = 1;
        for (int i = 0; i < 10; i++) {
            modNumber *= 10;
        }

        for (int i = 1; i <= 1000; i++) {
            long product = 1;
            for (int j = 0; j < i; j++) {
                product *= i;
                product %= modNumber;
            }
            sum += product;
            sum %= modNumber;
        }
        System.out.println(sum);
    }
}
