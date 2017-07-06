// sieve of eratosthenes
import java.util.*;
import java.math.*;
public class Solution {
    public static void main(String [] args) {
        int limit = 2000000;
        boolean[] isNotPrime = new boolean[limit + 1];
        for (int i = 4; i <= limit; i += 2) {
            isNotPrime[i] = true;
        }
        for (int i = 3; i <= Math.floor(Math.sqrt(limit)); i += 2) {
            if (isNotPrime[i]) {
                continue;
            }
            for (int j = i * i; j <= limit; j += i * 2) {
                isNotPrime[j] = true;
            }
        }
        long sum = 0;
        for (int i = 2; i <= limit; i++) {
            if (isNotPrime[i] == false) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
