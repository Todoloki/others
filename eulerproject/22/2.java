import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<String>();
        int numOfCases = scanner.nextInt();
        for (int i = 0; i < numOfCases; i++) {
            list.add(scanner.next());
        }
        Collections.sort(list);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            int sum = 0;
            for (int j = 0; j < s.length(); j++) {
                sum += s.charAt(j) - 'A' + 1;
            }
            sum *= i + 1;
            map.put(s, sum);
        }
        numOfCases = scanner.nextInt();
        for (int i = 0; i < numOfCases; i++) {
            String s = scanner.next();
            System.out.println(map.get(s));
        }
    }
}
