import java.util.*;
import java.math.*;
public class Solution {
    public static void main(String [] args) {
        int limit = 2000000;
        boolean[] isNotPrime = new boolean[(limit - 1) / 2 + 1];
        for (int i = 1; i <= (((int) Math.floor(Math.sqrt(limit))) - 1) / 2; i++) {
            if (isNotPrime[i] == true) {
                continue;
            }
            for (int j = ((2 * i + 1) * (2 * i + 1) - 1) / 2; j < isNotPrime.length; j += (2 * i + 1) * 2 / 2) {
                isNotPrime[j] = true;
            }
        }
        long sum = 2;
        for (int i = 1; i < isNotPrime.length; i++) {
            if (isNotPrime[i] == false) {
                sum += 2 * i + 1;
            }
        }
        System.out.println(sum);
    }
}
// improved sieve eratosthenes 
// use less space
