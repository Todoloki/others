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
        counter = getCounter(list, 0, 200, counter);
        System.out.println(counter);
    }
    public static long getCounter(List<Integer> list, int index, int remain, long counter) {
        if (index == list.size()) {
            counter++;
            return counter;
        }
        for (int i = 0; i <= remain / list.get(index); i++) {
            counter = getCounter(list, index + 1, remain - i * list.get(index), counter);
        }
        return counter;
    }
}
