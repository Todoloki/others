import java.io.*;
import java.util.*;

public class Mysample {
    public static void main(String[] args) {
        int limit = 9999;
        boolean[] isNotPrime = new boolean[(limit - 1) / 2 + 1];

        HashMap<String, List<Long>> map = new HashMap<String, List<Long>>();

        for (int i = 1; i < isNotPrime.length; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            long nextIndex = i;
            nextIndex = 2 * nextIndex + 1;
            if (nextIndex >= 1000)
                addToMap(nextIndex, map);
            nextIndex = nextIndex * nextIndex - 1;
            nextIndex /= 2;
            if (nextIndex >= isNotPrime.length) {
                continue;
            }
            for (int j = ((2 * i + 1) * (2 * i + 1) - 1) / 2; j < isNotPrime.length; j += 2 * i + 1) {
                isNotPrime[j] = true;
            }
        }

        for (String s : map.keySet()) {
            if (map.get(s).size() < 3) {
                // System.out.println("less");
                continue;
            }
            Collections.sort(map.get(s));
            List<Long> list = map.get(s);
            for (int i = 0; i < list.size() - 2; i++) {
                for (int j = i + 1; j < list.size() - 1; j++) {
                    for (int k = j + 1; k < list.size(); k++) {
                        long diff1 = list.get(j) - list.get(i);
                        long diff2 = list.get(k) - list.get(j);
                        if (diff1 == diff2) {
                            System.out.println(list.get(i) + " " + list.get(j) + " " + list.get(k));
                        }
                    }
                }
            }

        }
    }
    public static void addToMap(long number, HashMap<String, List<Long>> map) {
        List<Long> numbers = new ArrayList<Long>();
        long temp = number;
        while (temp != 0) {
            numbers.add(temp % 10);
            temp /= 10;
        }
        Collections.sort(numbers);
        String s = "";
        for (int i = 0; i < numbers.size(); i++) {
            s = s + numbers.get(i);
        }
        if (map.containsKey(s)) {
            map.get(s).add(number);
        }
        else {
            List<Long> list = new ArrayList<Long>();
            list.add(number);
            map.put(s, list);
        }
    }
}
