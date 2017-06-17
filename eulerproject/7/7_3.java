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
            int counter = 1;
            int start = 1;
            if (n == 1) {
                System.out.println(2);
                continue;
            }
            while (counter < n) {
                start += 2;
                if (isPrime(start)) {
                    counter++;
                }
            }
            System.out.println(start);
        }
    }
    public static boolean isPrime(int n) {
        if (n < 4) {
            return true;
        }
        if (n % 3 == 0) {
            return false;
        }
        int divisor = 5;
        while (divisor <= (int) Math.floor(Math.sqrt(n))) {
            if (n % divisor == 0) {
                return false;
            }
            if (n % (divisor + 2) == 0) {
                return false;
            }
            divisor += 6;
        }
        return true;
    }
}
// bug  divisor can be equal to the square root of n
// bug should also be careful about the edge case that n = 1
