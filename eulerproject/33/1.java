import java.util.*;
import java.math.*;
import java.io.*;

public class Mysample {
    public static void main(String [] args) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> list1 = new ArrayList<Integer>();
        for (int i = 10; i < 99; i++) {
            for (int j = i + 1; j <= 99; j++) {
                int t1 = i / 10;
                int d1 = i % 10;
                int t2 = j / 10;
                int d2 = j % 10;
                int gcd = getGCD(i, j);
                int k1 = i / gcd;
                int k2 = j / gcd;
                if (d1 == 0 && d2 == 0) {
                    continue;
                }
                if (t1 == t2) {
                    gcd = getGCD(d1, d2);
                    d1 /= gcd;
                    d2 /= gcd;
                    if (k1 == d1 && k2 == d2) {
                        list1.add(k1);
                        list.add(k2);
                        continue;
                    }
                }
                if (t1 == d2) {
                    gcd = getGCD(d1, t2);
                    d1 /= gcd;
                    t2 /= gcd;
                    if (k1 == d1 && k2 == t2) {
                        list1.add(k1);
                        list.add(k2);
                        continue;
                    }
                }
                if (d1 == t2) {
                    gcd = getGCD(t1, d2);
                    t1 /= gcd;
                    d2 /= gcd;
                    if (k1 == t1 && k2 == d2) {
                        list1.add(k1);
                        list.add(k2);
                        continue;
                    }
                }
                if (d1 == d2) {
                    gcd = getGCD(t1, t2);
                    t1 /= gcd;
                    t2 /= gcd;
                    if (k1 == t1 && k2 == t2) {
                        list1.add(k1);
                        list.add(k2);
                        continue;
                    }
                }
            }
        }
        int numerator = 1;
        for (int i = 0; i < list1.size(); i++) {
            numerator *= list1.get(i);
        }
        int denominator = 1;
        for (int i = 0; i < list.size(); i++) {
            denominator *= list.get(i);
        }
        int gcd = getGCD(numerator, denominator);
        int product = denominator / gcd;
        System.out.println(product);
    }
    public static int getGCD(int a, int b) {
        if (a <= 1 || b <= 1) {
            return 1;
        }
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (a % b == 0) {
            return b;
        }
        return getGCD(b, a % b);
    }
}
