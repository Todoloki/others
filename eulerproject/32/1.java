import java.util.*;
import java.math.*;
import java.io.*;

public class Mysample {
    public static void main(String [] args) {
        // get all permutations
        // check for every permutation
        // sum all the product that meets the requirement

        List<String> list = new ArrayList<String>();
        // to record if we have already used the specific number when generating permutations
        boolean[] visited = new boolean[10];
        getPermutation(list, visited, new ArrayList<Character>(), 0);
        HashSet<Integer> set = new HashSet<Integer>();
        for (String s : list) {
            // System.out.println(s);
            for (int i = 1; i <= s.length() / 2; i++) {
                for (int j = i + 1; j <= s.length() / 2 + 1; j++) {
                    String multiplicandStr = s.substring(0, i);
                    String multiplierStr = s.substring(i, j);
                    String productStr = s.substring(j);
                    // System.out.println(productStr);
                    int multiplicand = Integer.parseInt(multiplicandStr);
                    int multiplier = Integer.parseInt(multiplierStr);
                    int product = Integer.parseInt(productStr);
                    if (multiplicand * multiplier == product) {
                        set.add(product);
                    }
                }
            }
        }
        long sum = 0;
        for (int i : set) {
            sum += i;
        }
        System.out.println(sum);
    }
    public static void getPermutation(List<String> list, boolean[] visited, List<Character> permutation, int curLength) {
        if (curLength == 9) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < permutation.size(); i++) {
                sb.append(permutation.get(i));
            }
            // System.out.println(sb.toString());
            list.add(sb.toString());
            return ;
        }
        for (int i = 1; i <= 9; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                permutation.add((char)('0' + i));
                getPermutation(list, visited, permutation, curLength + 1);
                permutation.remove(permutation.size() - 1);
                visited[i] = false;
            }
        }
    }
}
// O(9!) to get all permutations
// C(8, 2) to find the position which we will split the permutation into multiplicand, multiplier and product.
