import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        int c1 = scanner.nextInt();
        int c2 = scanner.nextInt();
        
        
        long index1 = 1;
        long index2 = 1;
        
        long t1 = getNumber(c1, index1);
        long t2 = getNumber(c2, index2);
        
        while (t1 < N && t2 < N) {
            if (t1 == t2) {
                System.out.println(t1);
                index1++;
                t1 = getNumber(c1, index1);
                index2++;
                t2 = getNumber(c2, index2);
            }
            else if (t1 < t2) {
                index1++;
                t1 = getNumber(c1, index1);
            }
            else {
                index2++;
                t2 = getNumber(c2, index2);
            }
        }
        scanner.close();
    }
    public static long getNumber(int type, long index) {
        if (type == 3) {
            return index * (index + 1) / 2;
        }
        else if (type == 5) {
            return index * (3 * index - 1) / 2;
        }
        else {
            return index * (2 * index - 1);
        }
    }
}
// passed hackerrank
