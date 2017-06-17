// passed corresponding problem on hackerrank
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            boolean[] isNotPrime = new boolean[n + 1];
            for (int i = 2; i < isNotPrime.length; i++) {
                if (isNotPrime[i]) {
                    continue;
                }
                for (int j = 2; j <= n / i; j++) {
                    isNotPrime[i * j] = true;
                }
            }
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 2; i < isNotPrime.length; i++) {
                if (isNotPrime[i] == false) {
                    list.add(i);
                }
            }
            List<Integer> times = new ArrayList<Integer>();
            for (int i = 0; i < list.size(); i++) {
                times.add((int)(Math.floor(Math.log(n) / Math.log(list.get(i)))));
            }
            long product = 1;
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < times.get(i); j++) {
                    product *= list.get(i);
                }
            }
            System.out.println(product);
        }
    }
}
