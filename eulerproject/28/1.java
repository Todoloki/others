import java.util.*;
import java.math.*;
import java.io.*;

public class Mysample {
    public static void main(String [] args) {
        long sum = 1;
        int cur = 1;
        for (int i = 1; i <= 500; i++) {
            int gap = 2 * i;
            for (int j = 0; j < 4; j++) {
                // System.out.println(cur);
                cur += gap;
                sum += cur;
            }
        }
        System.out.println(sum);
    }
}
