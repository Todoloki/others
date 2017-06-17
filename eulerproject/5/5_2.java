/**
 * Wanna play splatoon.
 */
 // get all the primes less than O(n * n)
 // get the minmum common multiplier costs O(n)
 // find how many times a prime can appear in minimum common cost O(n) time
 // O(n) space needed
import java.util.*;
public class Solution {
    public static void main(String [] args)
    {
        int num = 20;
        List<Long> primes = new ArrayList<Long>();
        int maxPrime = num;
        boolean[] isNotPrime = new boolean[(int)maxPrime + 1];
        for (int i = 2; i < isNotPrime.length; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            for (int j = 2; j <= maxPrime / i; j++) {
                isNotPrime[i * j] = true;
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 2; i <= maxPrime; i++) {
            if (isNotPrime[i] == false) {
                list.add(i);
            }
        }
        List<Integer> times = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            times.add((int)Math.floor(Math.log(num) / Math.log(list.get(i))));
        }
        int product = 1;
        for (int i = 0; i < list.size(); i++) {
            //System.out.println(list.get(i) + " " + times.get(i));
            for (int j = 0; j < times.get(i); j++) {
                product *= list.get(i);
            }
        }
        System.out.println(product);
    }
}
