import java.util.*;
public class Solution {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int max = 0;
        for (int i = 2; i < s.length(); i += 2) {
            String left = s.substring(0, (s.length() - i) / 2);
            String right = s.substring((s.length() - i) / 2, (s.length() - i));
            //System.out.println(left + " " + right);
            if (left.equals(right)) {
                System.out.println(s.length() - i);
                return ;
            }
        }
        System.out.println(max);
    }
}
