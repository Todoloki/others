import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int[] resAs = new int[2000 + 1];
        int[] resBs = new int[2000 + 1];
        int maxNumber = 2000 * 2000 + 2000 * 2000 + 2000;
        boolean[] isNotPrime = new boolean[(maxNumber - 1) / 2 + 1];
        for (int i = 1; i < isNotPrime.length; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            if (2 * i + 1 > (int) Math.floor(Math.sqrt((isNotPrime.length - 1) * 2))) {
                break;
            }
            for (int j = ((2 * i + 1) * (2 * i + 1) - 1) / 2; j < isNotPrime.length; j += 2 * i + 1) {
                isNotPrime[j] = true;
            }
        }
        HashSet<Integer> primes = new HashSet<Integer>();
        primes.add(2);
        for (int i = 1; i < isNotPrime.length; i++) {
            if (isNotPrime[i] == false) {
                primes.add(2 * i + 1);
            }
        }
        int counter = 0;
        int resA = 0;
        int resB = 0;
        for (int i = 1; i < resAs.length; i++) {
            int a = i;
            int b = 0;
            for (b = -i; b <= i; b++) {
                int start = 0;
                int curNumber = start * start + start * a + b;
                while (primes.contains(curNumber)) {
                    start++;
                    curNumber = start * start + start * a + b;
                }
                if (start > counter) {
                    counter = start;
                    resA = a;
                    resB = b;
                }
            }
            b = i;
            for (a = - i + 1; a < i - 1; a++) {
                int start = 0;
                int curNumber = start * start + start * a + b;
                while (primes.contains(curNumber)) {
                    start++;
                    curNumber = start * start + start * a + b;
                }
                if (start > counter) {
                    counter = start;
                    resA = a;
                    resB = b;
                }
            }
            resAs[i] = resA;
            resBs[i] = resB;
        }
        //int numOfCases = scanner.nextInt();
        //for (int i = 0; i < numOfCases; i++) {
            int num = scanner.nextInt();
            System.out.println(resAs[num] + " " + resBs[num]);
        //}
    }
}
// passed hackerrank
