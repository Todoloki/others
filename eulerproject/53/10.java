import java.io.*;
import java.util.*;
import java.math.*;

public class Mysample {
    public static void main(String[] args) {
        int counter = 0;
        int n = 100;
        int r = 0;
        int cnr = 1;
        int limit = 1000000;
        while (r <= (n + 1) / 2) {
            if (cnr <= limit) {
                // cnr = n! / r! * (n - r)!
                // cnr+1 = n! / (r + 1) * (n - r)
                int right = cnr * (n - r) / (r + 1);
                cnr = right;
                r++;
            }
            else {
                // cnr = n! / r! * (n - r)!
                // cn-1r = (n - 1)! / r! * (n - r - 1)!
                int up = cnr * (n - r) / n;
                cnr = up;
                counter += n + 1 - 2 * r;
                n--;
            }
        }
        System.out.println(counter);
    }
}
// use O(1) memory instead of a 1D array
// use more information about combination
