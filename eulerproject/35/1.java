import java.io.*;
import java.util.*;

public class Mysample {
    public static void main(String[] args) {
        int limit = 1000000;
        boolean[] isNotPrime = new boolean[(limit - 1) / 2 + 1];
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        HashSet<Integer> set = new HashSet<Integer>();
        map.put(2, false);
        set.add(2);
        for (int i = 1; i < isNotPrime.length; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            map.put(2 * i + 1, false);
            set.add(2 * i + 1);
            for (int j = ((2 * i + 1) * (2 * i + 1) - 1) / 2; j >= 0 && j < isNotPrime.length; j += 2 * i + 1) {
                isNotPrime[j] = true;
            }
        }
        int counter = 0;
        for (int key : set) {
            List<Integer> rotations = getRotations(key);
            boolean containsAll = true;
            for (int rotation : rotations) {
                if (map.containsKey(rotation)) {
                    map.put(rotation, true);

                }
                else {
                    containsAll = false;
                    break;
                }
            }
            if (containsAll) {
                counter++;
            }
        }
        System.out.println(counter);
    }
    public static List<Integer> getRotations(int num) {
        List<Integer> numbers = new ArrayList<Integer>();
        int base = 1;
        int limit = 1;
        while (num / base > 9) {
            base *= 10;
            limit++;
        }
        numbers.add(num);
        for (int i = 1; i < limit; i++) {
            int newNumber = num / base  + num % base * 10;
            numbers.add(newNumber);
            num = newNumber;
        }
        return numbers;
    }
}
