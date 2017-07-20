import java.util.*;
import java.math.*;
import java.io.*;

public class Mysample {
    public static void main(String [] args) {
        // at most six digits for every number
        long res = 0;
        for (int i = 10; i < 1000000; i++) {
            int number = i;
            int sum = 0;
            while (number != 0) {
                int curNumber = number % 10;
                number /= 10;
                sum += curNumber * curNumber * curNumber * curNumber * curNumber;
            }
            if (sum == i) {
                res += sum;
            }
        }
        System.out.println(res);
    }
}
