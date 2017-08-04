import java.io.*;
import java.util.*;

public class Mysample {
    public static void main(String[] args) {
        int limit = 100;
        int counterLimit = 11;
        int counter = 0;

        long sum = 0;
        while (counter < counterLimit) {
            counter = 0;
            sum = 0;

            boolean[] isNotPrime = new boolean[(limit - 1) / 2 + 1];
            HashSet<Integer> primes = new HashSet<Integer>();
            List<Integer> list = new ArrayList<Integer>();
            primes.add(2);
            list.add(2);
            for (int i = 1; i < isNotPrime.length; i++) {
                if (isNotPrime[i]) {
                    continue ;
                }
                primes.add(2 * i + 1);
                list.add(2 * i + 1);
                long nextInt = ((2 * (long)i + 1) * (2 * i + 1) - 1) / 2;
                if (nextInt >= isNotPrime.length) {
                    continue ;
                }
                for (int j = ((2 * i + 1) * (2 * i + 1) - 1) / 2; j < isNotPrime.length; j += 2 * i + 1) {
                    isNotPrime[j] = true;
                }
            }
            int index = 0;
            while (index < list.size()) {
                if (list.get(index) < 10) {
                    index++;
                    continue;
                }
                int base = 1;
                int curPrime = list.get(index);
                while (curPrime / base > 9) {
                    base *= 10;
                }
                int leftTruncate = curPrime;
                int rightTruncate = curPrime;
                boolean isValid = true;
                while (base != 1) {
                    leftTruncate = leftTruncate - leftTruncate / base * base;
                    rightTruncate = rightTruncate / 10;
                    if (primes.contains(leftTruncate) == false || primes.contains(rightTruncate) == false) {
                        isValid = false;
                        break;
                    }
                    base /= 10;
                }
                if (isValid) {
                    counter++;
                    // System.out.println(curPrime);
                    sum += curPrime;
                }
                index++;
            }
            limit *= 10;
        }
        System.out.println(sum);
    }
}
