import java.io.*;
import java.util.*;

public class Mysample {
    public static class Pair {
        int sum;
        int count;
        Pair (int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }
    public static void main(String[] args) {
        int limit = 1000000;
        boolean[] isNotPrime = new boolean[(limit - 1) / 2 + 1];
        List<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> primes = new HashSet<Integer>();
        list.add(2);
        primes.add(2);

        for (int i = 1; i < isNotPrime.length; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            primes.add(2 * i + 1);
            list.add(2 * i + 1);
            long nextIndex = 2 * i + 1;
            nextIndex *= nextIndex;
            nextIndex -= 1;
            nextIndex /= 2;
            if (nextIndex >= isNotPrime.length) {
                continue;
            }
            for (int j = ((2 * i + 1) * (2 * i + 1) - 1) / 2; j < isNotPrime.length; j += i * 2 + 1) {
                isNotPrime[j] = true;
            }
        }
        int max = 0;
        int maxPrime = 0;
        for (int i = 0; i < list.size(); i++) {
            int sum = 0;
            int index = i;
            while (index < list.size()) {
                sum += list.get(index);
                if (sum > limit) {
                    break;
                }
                if (primes.contains(sum) && index - i + 1 > max) {
                    max = index - i + 1;
                    maxPrime = sum;
                }
                index++;
            }
        }
        System.out.println(maxPrime);
    }
}
