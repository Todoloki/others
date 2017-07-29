import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int[] bases = new int[]{1, 10, 100, 1000, 10000};
        long sum1 = 0;
        long sum2 = 0;
        HashSet<String> set = new HashSet<String>();
        for (int k = 1; k <= 9; k++) {
            for (int i = 0; i < 1000; i++) {
                for (int indexI = 0; indexI < (i < 100 ? 1 : 4); indexI++) {
                    int numerator = i / bases[3  - indexI] * bases[4 - indexI] + k * bases[3 - indexI] + i % bases[3 - indexI];
                    for (int j = i + 1; j < 1000; j++) {
                        for (int indexJ = 0; indexJ < (j < 100 ? 1 : 4); indexJ++) {
                            if (indexJ > 0 && j / 100 < numerator / 1000) {
                                break;
                            }
                            int denominator = j / bases[3  - indexJ] * bases[4 - indexJ] + k * bases[3 - indexJ] + j % bases[3 - indexJ]; 
                            if (numerator * j == i * denominator && set.contains(numerator + " "  + denominator) == false) {
                                set.add(numerator + " " + denominator);
                                sum1 += numerator;
                                sum2 += denominator;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(sum1 + " " + sum2);
    }
}
// his solution is correct and just skip many unnessary cases. So smart.
// merge this with the previous should pass all the cases.
