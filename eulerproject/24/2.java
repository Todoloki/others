import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        for (int i = 0; i < numOfCases; i++) {
            long order = scanner.nextLong();
            order--;
            List<Character> list = new ArrayList<Character>();
            StringBuffer sb = new StringBuffer();
            for (char c = 'a'; c <= 'm'; c++) {
                list.add(c);
            }
            long curBase = 1;
            for (int j = 1; j <= 12; j++) {
                curBase *= j;
            }
            long curDivisor = 12;
            while (list.size() > 0) {
                int index = (int)(order / curBase);
                char c = list.remove(index);
                sb.append(c);
                order %= curBase;
                if (curDivisor > 0) {
                    curBase /= curDivisor;
                    curDivisor--;
                }
            }
            System.out.println(sb.toString());
        }
    }
}
// passed hackerrank
