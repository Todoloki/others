import java.io.*;
import java.util.*;

public class Mysample {
    public static void main(String[] args) {
        int limit = 10;

        boolean find = false;

        while (true) {
            boolean[] isNotPrime = new boolean[(limit - 1) / 2 + 1];
            List<Integer> primes = new ArrayList<Integer>();
            primes.add(2);
            for (int i = 1; i < isNotPrime.length; i++) {
                if (isNotPrime[i]) {
                    continue;
                }
                primes.add(2 * i + 1);
                long nextInt = 2 * i + 1;
                nextInt *= nextInt;
                nextInt -= 1;
                nextInt /= 2;
                if (nextInt >= isNotPrime.length) {
                    continue;
                }
                for (int j = ((2 * i + 1) * (2 * i + 1) - 1) / 2; j < isNotPrime.length; j += 2 * i + 1) {
                    isNotPrime[j] = true;
                }
            }

            int[] numOfPrimeFactor = new int[limit + 1];
            for (int i = 2; i < numOfPrimeFactor.length; i++) {
                int index = 0;
                int counter = 0;
                int tempNum = i;
                while (index < primes.size() && primes.get(index) <= (int) Math.floor(Math.sqrt(i))) {
                    if (tempNum % primes.get(index) == 0) {
                        counter++;
                        while (tempNum % primes.get(index) == 0) {
                            tempNum /= primes.get(index);
                        }
                        if (tempNum == 1) {
                            break;
                        }
                    }
                    index++;
                }
                if (tempNum != 1) {
                    counter++;
                }
                numOfPrimeFactor[i] = counter;
            }

            for (int i = 2; i < limit - 3; i++) {
                int t1 = numOfPrimeFactor[i];
                int t2 = numOfPrimeFactor[i + 1];
                int t3 = numOfPrimeFactor[i + 2];
                int t4 = numOfPrimeFactor[i + 3];

                if (t1 == 4 && t2 == 4 && t3 == 4 && t4 == 4) {
                    System.out.println(i);
                    return ;
                }
            }
            limit *= 10;
        }

    }
}
// if a number has a factor that is larger than the square root of this number
// then the factor must be a prime and it is the only prime factor that is larger than the square root of this number
