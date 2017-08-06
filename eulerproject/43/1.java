import java.io.*;
import java.util.*;

public class Mysample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i <= 9; i++) {
            numbers.add(i);
        }
        List<Long> permutations = getAllPermutations(numbers);
        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        primes.add(11);
        primes.add(13);
        primes.add(17);
        long sum = 0;
        for (long permutation : permutations) {
            long lessThan = 1;
            int index = 0;
            for (int i = 0; i < 9; i++) {
                lessThan *= 10;
            }
            long moreThan = lessThan / 1000;
            boolean valid = true;
            while (moreThan != 0) {
                long curNumber = permutation % lessThan;
                curNumber /= moreThan;
                if (curNumber % primes.get(index) != 0) {
                    valid = false;
                    break;
                }
                moreThan /= 10;
                lessThan /= 10;
                index++;
            }
            if (valid) {
                sum += permutation;
            }
        }
        System.out.println(sum);
    }
    public static List<Long> getAllPermutations(List<Integer> numbers) {
        boolean[] visited = new boolean[numbers.size()];
        List<Long> list = new ArrayList<Long>();
        collectPermutations(numbers, visited, list, 0, 0);
        return list;
    }
    public static void collectPermutations(List<Integer> numbers, boolean[] visited, List<Long> list, long curNumber, int curLength) {
        if (curLength == numbers.size()) {
            list.add(curNumber);
            return ;
        }
        for (int i = 0; i < visited.length; i++) {
            if (curLength == 0 && i == 0) {
                continue;
            }
            if (visited[i] == false) {
                visited[i] = true;
                collectPermutations(numbers, visited, list, curNumber * 10 + numbers.get(i), curLength + 1);
                visited[i] = false;
            }
        }
    }
}
