import java.io.*;
import java.util.*;

public class Mysample {
    public static void main(String[] args) {
        int number = 9;
        boolean find = false;
        while (find == false) {
            List<Long> permutations = getPermutations(number);
            Collections.sort(permutations, Collections.reverseOrder());
            int index = 0;
            while (index < permutations.size()) {
                if (isPrime(permutations.get(index))) {
                    System.out.println(permutations.get(index));
                    find = true;
                    break;
                }
                index++;
            }
            number--;
        }

    }
    public static List<Long> getPermutations(int max) {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i <= max; i++) {
            numbers.add(i);
        }
        List<Long> res = new ArrayList<Long>();
        collectPermutations(res, numbers, new boolean[numbers.size()], 0, 0);
        return res;
    }
    public static void collectPermutations(List<Long> res, List<Integer> numbers, boolean[] visited, long curNumber, int curLength) {
        if (curLength == numbers.size()) {
            res.add(curNumber);
            return ;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                collectPermutations(res, numbers, visited, curNumber * 10 + numbers.get(i), curLength + 1);
                visited[i] = false;
            }
        }
    }
    public static boolean isPrime(long num) {
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (long p = 6; p - 1 <= (int) Math.floor(Math.sqrt(num)); p += 6) {
            if (num % (p - 1) == 0) {
                return false;
            }
            if (num % (p + 1) == 0) {
                return false;
            }
        }
        return true;
    }
}
