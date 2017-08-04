import java.io.*;
import java.util.*;

public class Mysample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }
        List<Long> permutations = new ArrayList<Long>();
        getPermutations(numbers, new boolean[numbers.size()], permutations, 0, 0);
        Collections.sort(permutations, Collections.reverseOrder());
        int index = 0;
        while (index < permutations.size()) {
            long curPermutation = permutations.get(index);
            if (canBeComposed(curPermutation)) {
                System.out.println(curPermutation);
                break;
            }
            index++;
        }
    }
    public static void getPermutations(List<Integer> numbers, boolean[] visited, List<Long> permutations, long curNumber, int curLength) {
        if (curLength == numbers.size()) {
            permutations.add(curNumber);
            return ;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                getPermutations(numbers, visited, permutations, curNumber * 10 + numbers.get(i), curLength + 1);
                visited[i] = false;
            }
        }
    }
    public static boolean canBeComposed(long number) {
        String num = "" + number;
        for (int l = 1; l <= 4; l++) {
            int t = 1;
            String s = num.substring(0, l);
            int n = Integer.parseInt(s);
            int start = l;
            int sum = n + n;
            while (start < num.length()) {
                String next = "" + sum;
                if (start + next.length() > num.length()) {
                    break;
                }
                String concated = num.substring(start, start + next.length());
                if (concated.equals(next) == false) {
                    break;
                }
                else {
                    start += next.length();
                    sum += n;
                }
                if (start == num.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
