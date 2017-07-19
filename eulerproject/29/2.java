import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int limit = scanner.nextInt();
        HashSet<Integer> set = new HashSet<Integer>();
        long total = (long) (limit - 1) * (limit - 1);
        for (int i = 2; i <= limit; i++) {
            if (set.contains(i)) {
                continue;
            }
            List<Integer> list = new ArrayList<Integer>();
            list.add(i);
            long curNumber = (long) i * i;
            while (curNumber <= limit) {
                list.add((int) curNumber);
                curNumber *= i;
            }
            for (int j = 1; j < list.size(); j++) {
                boolean[] table = new boolean[limit + 1];
                for (int k = 0; k < j; k++) {
                    int t1 = k + 1;
                    int t2 = j + 1;
                    int gcd = getGCD(t1, t2);
                    long lcm = (long) gcd * t1 / gcd * t2 / gcd;
                    for (long t = lcm; t <= t1 * limit; t += lcm) {
                        int index = (int) t / t2;
                        if (index == 1) {
                            continue;
                        }
                        if (table[index] == false) {
                            table[index] = true;
                            total--;
                        }
                    }
                }
            }
            for (int j : list) {
                set.add(j);
            }
        }
        System.out.println(total);
    }
    public static int getGCD(int a, int b) {
        if (a == 1 || b == 1) {
            return 1;
        }
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (a % b == 0) {
            return b;
        }
        return getGCD(b, a % b);
    }
}
// passed hackerrank
