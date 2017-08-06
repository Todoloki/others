import java.io.*;
import java.util.*;

public class Mysample {
    public static void main(String[] args) {
        long index1 = 286;
        long index2 = 166;
        long index3 = 144;

        long t1 = index1 * (index1 + 1) / 2;
        long t2 = index2 * (index2 * 3 - 1) / 2;
        long t3 = index3 * (index3 * 2 - 1);

        while (t1 != t2 || t2 != t3) {
            if (t1 <= t2 && t1 <= t3) {
                index1++;
                t1 = index1 * (index1 + 1) / 2;
            }
            else if (t2 <= t1 && t2 <= t3) {
                index2++;
                t2 = index2 * (index2 * 3 - 1) / 2;
            }
            else {
                index3++;
                t3 = index3 * (index3 * 2 - 1);
            }
        }

        System.out.println(t1);
    }
}
