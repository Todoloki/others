import java.util.*;
public class Solution {
    public static void main(String [] args) {
        boolean[] isNotPrime = new boolean[2000000];
        long sum = 0;
        for (int i = 2; i < isNotPrime.length; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            sum += i;
            for (int j = 2; j < 2000000 / i; j++) {
                isNotPrime[i * j] = true;
            }
        }
        System.out.println(sum);
    }
}
// O(n * n)
