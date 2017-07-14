import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 1);
        int[] fab1 = new int[]{1};
        int[] fab2 = new int[]{1};
        int[] fab3 = new int[]{2};
        int index = 3;
        while (fab3.length <= 5000) {
            index++;
            fab1 = fab2;
            fab2 = fab3;
            fab3 = new int[fab2.length];
            int c = 0;
            for (int i = 0; i < fab2.length; i++) {
                int d1 = i < fab1.length ? fab1[i] : 0;
                int d2 = fab2[i];
                int sum = d1 + d2 + c;
                c = sum / 10;
                sum %= 10;
                fab3[i] = sum;
            }
            if (c != 0) {
                int[] temp = new int[fab3.length + 1];
                for (int i = 0; i < fab3.length; i++) {
                    temp[i] = fab3[i];
                }
                temp[temp.length - 1] = 1;
                fab3 = temp;
            }
            if (map.containsKey(fab3.length) == false) {
                map.put(fab3.length, index);
            }
        }
        for (int i = 0; i < numOfCases; i++) {
            int key = scanner.nextInt();
            System.out.println(map.get(key));
        }
    }
}
// passed hackerrank
