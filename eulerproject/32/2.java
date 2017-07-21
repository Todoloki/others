import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int numOfDigits = scanner.nextInt();
        List<String> list = new ArrayList<String>();
        boolean[] visited = new boolean[numOfDigits + 1];
        getPermutations(list, numOfDigits, 0, visited, new ArrayList<Character>());
        HashSet<Integer> set = new HashSet<Integer>();
        for (String s : list) {
            for (int i = 1; i < s.length() - 2; i++) {
                for (int j = i + 1; j < s.length() - 1; j++) {
                    String multiplicand = s.substring(0, i);
                    String multiplier = s.substring(i, j);
                    String product = s.substring(j);
                    if (product.length() < Math.max(multiplicand.length(), multiplier.length())) {
                        continue;
                    }
                    int mul1 = Integer.parseInt(multiplicand);
                    int mul2 = Integer.parseInt(multiplier);
                    int mul3 = Integer.parseInt(product);
                    if (mul1 * mul2 == mul3) {
                        set.add(mul3);
                    }
                }
            }
        }
        int sum = 0;
        for (int i : set) {
            sum += i;
        }
        System.out.println(sum);
    }
    public static void getPermutations(List<String> list, int targetLength, int curLength, boolean[] visited, List<Character> permutation) {
        if (curLength == targetLength) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < permutation.size(); i++) {
                sb.append(permutation.get(i));
            }
            list.add(sb.toString());
            return ;
        }
        for (int i = 1; i < visited.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                permutation.add((char)('0' + i));
                getPermutations(list, targetLength, curLength + 1, visited, permutation);
                permutation.remove(permutation.size() - 1);
                visited[i] = false;
            }
        }
    }
}
