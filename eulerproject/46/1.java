import java.io.*;
import java.util.*;

public class Mysample {
    public static void main(String[] args) {
        int limit = 10;

        boolean find = false;

        while (find == false) {
            boolean[] isNotPrime = new boolean[(limit - 1) / 2 + 1];

            HashSet<Integer> primes = new HashSet<Integer>();

            for (int i = 1; i < isNotPrime.length; i++) {
                if (isNotPrime[i]) {
                    int cur = 2 * i + 1;
                    boolean findCur = false;
                    for (int prime : primes) {
                        int target = (cur - prime) / 2;

                        int n = (int) Math.floor(Math.sqrt(target));
                        if (n * n == target) {
                            findCur = true;
                        }
                    }
                    if (findCur == false) {
                        System.out.println(2 * i + 1);
                        return ;
                    }
                    continue;
                }
                primes.add(2 * i + 1);
                long nextIndex = (((long)2 * i + 1) *  (2 * i + 1) - 1) / 2;
                if (nextIndex >= isNotPrime.length) {
                    continue;
                }
                for (int j = ((2 * i + 1) * (2 * i + 1) - 1) / 2; j < isNotPrime.length; j += 2 * i + 1) {
                    isNotPrime[j] = true;
                }
            }
            limit *= 10;
        }

    }
}
