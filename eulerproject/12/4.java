import java.util.*;
import java.math.*;
public class Solution {
    public static void main(String [] args) {
        int limit = 500;
        int n = 1;
        int primeMax = (int) Math.floor(Math.sqrt(Integer.MAX_VALUE));
        boolean[] isNotPrime = new boolean[primeMax + 1];
        for (int i = 2; i <= primeMax; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            for (int j = i * i; j <= primeMax; j += i) {
                isNotPrime[j] = true;
            }
        }
        List<Integer> primes = new ArrayList<Integer>();
        for (int i = 2; i <= primeMax; i++) {
            if (isNotPrime[i] == false) {
                primes.add(i);
            }
        }
        int counter = 0;
        int curNumber = 1;
        while (counter <= limit) {
            curNumber++;
            n += curNumber;
            counter = 1;
            int temp = n;
            for (int i = 0; i < primes.size(); i++) {
                if (temp % primes.get(i) == 0) {
                    int times = 0;
                    while (temp % primes.get(i) == 0) {
                        times++;
                        temp /= primes.get(i);
                    }
                    counter *= times + 1;
                    if (temp == 1) {
                        break;
                    }
                }
            }
        }
        System.out.println(n);
    }
}
