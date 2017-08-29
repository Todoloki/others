import java.io.*;
import java.util.*;

public class Mysample {
    public static void main(String[] args) {
        long base = 1;
        while (base <= Long.MAX_VALUE / 10) {
            base *= 10;
            boolean find = false;
            for (long num = base / 10; num <= (long) Math.floor(base / 6); num++) {
                HashMap<Integer, Integer> times = new HashMap<Integer, Integer>();
                long temp = num;
                while (temp != 0) {
                    int curD = (int) (temp % 10);
                    times.put(curD, times.getOrDefault(curD, 0) + 1);
                    temp /= 10;
                }
                boolean isValid = true;
                for (long mul = 2; mul <= 6; mul++) {
                    long newNumber = mul * num;
                    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
                    while (newNumber != 0) {
                        int curD = (int)(newNumber % 10);
                        newNumber /= 10;
                        map.put(curD, map.getOrDefault(newNumber, 0) + 1);
                    }
                    for (int key : times.keySet()) {
                        if (map.containsKey(key) == false || map.get(key) != times.get(key)) {
                            isValid = false;
                            break;
                        }

                    }
                    if (isValid == false) {
                        break;
                    }
                }
                if (isValid) {
                    System.out.println(num);
                    find = true;
                    break;
                }
            }
            if (find) {
                break;
            }
        }
    }
}
