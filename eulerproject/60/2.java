import java.io.*;
import java.util.*;
import java.math.*;

public class Mysample {
    public static void main(String[] args) {
        int limit = 100;
        boolean find = false;
        boolean nextTime = false;
        int minSum = -1;
        while (nextTime == false) {
            if (find == false)
                limit *= 10;
            System.out.println(limit);
            boolean[] isNotPrime = new boolean[(limit - 1 - 1)/ 2 + 1];
            List<Integer> primes = new ArrayList<Integer>();
            HashSet<Integer> set = new HashSet<Integer>();
            String maxString = "" + Long.MAX_VALUE;
            primes.add(2);
            set.add(2);
            HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
            for (int i = 1; i < isNotPrime.length; i++) {
                if (isNotPrime[i]) {
                    continue;
                }
                primes.add(i * 2 + 1);
                set.add(2 * i + 1);
                long temp = 2 * i + 1;
                if ((temp * temp - 1) / 2 >= isNotPrime.length) {
                    continue;
                }
                for (int j = ((2 * i + 1) * (2 * i + 1) - 1) / 2; j < isNotPrime.length; j += 2 * i + 1) {
                    isNotPrime[j] = true;
                }
            }

            for (int i = 0; i < primes.size(); i++) {
                for (int j = i + 1; j < primes.size(); j++) {
                    String p1 = "" + primes.get(i) + primes.get(j);
                    String p2 = "" + primes.get(j) + primes.get(i);
                    if (p1.length() >= maxString.length()) {
                        break;
                    }
                    if (isPrime(Long.parseLong(p1)) && isPrime(Long.parseLong(p2))) {
                        // System.out.println(primes.get(i));
                        // System.out.println(primes.get(j));
                        if (map.containsKey(primes.get(i))) {
                            map.get(primes.get(i)).add(primes.get(j));
                        }
                        else {
                            HashSet<Integer> tempSet = new HashSet<Integer>();
                            tempSet.add(primes.get(j));
                            map.put(primes.get(i), tempSet);
                        }
                    }
                }
            }
            /*
            for (int i = 0; i < primes.size(); i++) {
                if (map.containsKey(primes.get(i)) == false) {
                    continue;
                }
                System.out.println(primes.get(i));
                HashSet<Integer> mySet = map.get(primes.get(i));
                for (int s : mySet) {
                    System.out.print(s + " ");
                }
                System.out.println("");
                System.out.println("");
            }
            */
            for (int i = 0; i < primes.size(); i++) {
                if (map.containsKey(primes.get(i))) {
                    if (map.get(primes.get(i)).size() < 4) {
                        continue;
                    }
                    int s = -1;
                    s = findFive(map, map.get(primes.get(i)), primes.get(i), s, 3);
                    if (s != -1) {
                        minSum = minSum == -1 ? s : Math.min(minSum, s);
                    }
                }
            }
            if (minSum != -1) {
                if (find == false) {
                    find = true;
                    limit = minSum + 20;
                }
                else {
                    nextTime = true;
                }
            }
        }
        System.out.println(minSum);
    }
    public static int findFive(HashMap<Integer, HashSet<Integer>> map, HashSet<Integer> nextSet, int curSum, int minSum, int size) {
        // int sum = -1;
        for (int next : nextSet) {
            if (map.containsKey(next)) {
                HashSet<Integer> set = map.get(next);
                HashSet<Integer> union = new HashSet<Integer>();
                for (int i1 :  nextSet) {
                    if (set.contains(i1)) {
                        union.add(i1);
                    }
                    if (union.size() >= size) {
                        /*
                        System.out.println(next);
                        for (int i : set) {
                            System.out.print(i + " ");
                        }
                        System.out.println("");
                        System.out.println("");
                        */
                        int min = -1;
                        for (int temp : union) {
                            min = min == -1 ? temp : Math.min(min, temp);
                        }
                        if (size == 1) {
                            // System.out.println(min);
                            minSum = minSum == -1 ? curSum + next + min : Math.min(minSum, curSum + next + min);
                            continue;
                        }
                        minSum = findFive(map, union, curSum + next, minSum, size - 1);
                    }
                }
            }
        }
        return minSum;
    }
    public static boolean isPrime(long num) {
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        long factor = 6;
        while (factor - 1 <= (long) Math.floor(Math.sqrt(num))) {
            if (num % (factor - 1) == 0) {
                return false;
            }
            if (num % (factor + 1) == 0) {
                return false;
            }
            factor += 6;
        }
        return true;
    }
}
// can calcuate the minimum sum
// less than a minute on a macbook pro hhhhhhhhh
// I think this will be it.
