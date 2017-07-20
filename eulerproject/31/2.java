import java.util.*;
import java.math.*;
import java.io.*;

public class Mysample {
    public static void main(String [] args) {
        // brute force first
        // the value of coin that we need to get is 200
        List<Integer> list = new ArrayList<Integer>();
        list.add(200);
        list.add(100);
        list.add(50);
        list.add(20);
        list.add(10);
        list.add(5);
        list.add(2);
        long counter = 0;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        counter = getCounter(list, 0, 200, counter, map);
        System.out.println(counter);
    }
    public static long getCounter(List<Integer> list, int index, int remain, long counter, HashMap<String, Integer> map) {
        String key = remain + " " + index;
        if (map.containsKey(key)) {
            int temp = map.get(key);
            counter += temp;
            return counter;
        }
        if (index == list.size()) {
            counter++;
            return counter;
        }
        long temp = 0;
        for (int i = 0; i <= remain / list.get(index); i++) {
            temp = getCounter(list, index + 1, remain - i * list.get(index), temp, map);
        }
        map.put(key, (int)temp);
        counter += temp;
        return counter;
    }
}

// can use memorizatation (dynamic programming)
// a large problem can be solved (get the optimal solution) by solving small problems (get the optimal solution of sub problems).
// duplicate sub problems
