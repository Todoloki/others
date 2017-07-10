import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int[] steps = new int[5000001];
        int[] maxes = new int[5000001];
        int numOfCases = scanner.nextInt();
        
        int max = 0;
            int maxNumber = 1;
        maxes[1] = 1;
            for (int j = 2; j <= 5000000; j++) {
                int step = 0;
                long temp = j;
                while (temp != 1) {
                    if (temp < steps.length && steps[(int)temp] > 0) {
                        step += steps[(int) temp];
                        break;
                    }
                    if (temp % 2 == 0) {
                        temp /= 2;
                    }
                    else {
                        temp *= 3;
                        temp += 1;
                    }
                    step++;
                }
                steps[j] = step;
                if (step >= max) {
                    max = step;
                    maxNumber = j;
                }
                maxes[j] = maxNumber;
            }
        
        for (int i = 0; i < numOfCases; i++) {
            int limit = scanner.nextInt();
            System.out.println(maxes[limit]);
        }
    }
}
// pre-compute for all possible numbers
// should read the question carefully here, two numbers with the same length of chain we will chose the larger one
