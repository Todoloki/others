import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        // calculate results for every possible number that will appear in the 
        // test cases first
        int[] results = new int[10000];
        int max = 0;
        int curRes = 0;
        for (int cur = 2; cur < 10000; cur++) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            int remainder = 10;
            int curLength = 0;
            while (remainder != 0) {
                if (map.containsKey(remainder)) {
                    int formerLength = map.get(remainder);
                    if (curLength - formerLength > max) {
                        max = curLength - formerLength;
                        curRes = cur;
                    }
                    break;
                }
                map.put(remainder, curLength);
                remainder %= cur;
                remainder *= 10;
                curLength++;
            }
            results[cur] = curRes;
        }
        
        // 
        for (int i = 0; i < numOfCases; i++) {
            int num = scanner.nextInt();
            System.out.println(results[num - 1]);
        }
    }
}
// I noticed that I will always calculate and store results for all possible test cases and just read them out given
// a test case.
