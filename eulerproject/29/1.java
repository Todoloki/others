import java.util.*;
import java.math.*;
import java.io.*;

public class Mysample {
    public static void main(String [] args) {
        int limit = 100;
        HashSet<String> set = new HashSet<String>();
        for (int i = 2; i <= 100; i++) {
            for (int j = 2; j <= 100; j++) {
                BigInteger b1 = new BigInteger("" + i);
                BigInteger power = b1.pow(j);
                set.add(power.toString());
            }
        }
        System.out.println(set.size());
    }
}
// brute force
