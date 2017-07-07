import java.util.*;
import java.math.*;
public class Solution {
    public static void main(String [] args) {
        int limit = 5;
        int n = 1;
        int curNumber = 1;
        int counter = 1;
        while (counter <= limit) {
            curNumber += 1;
            n += curNumber;
            counter = 0;
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    counter++;
                }
            }
        }
        System.out.println(n);
    }
}
