import java.io.*;
import java.util.*;

public class Mysample {
    public static void main(String[] args) {
        int counter = 0;
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        for (int i = 1; i <= 100; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            for (int j = 0; j < list.size() - 1; j++) {
                int t = list.get(j) + list.get(j + 1);
                if (t >= 1000000) {
                    counter += i + 1 - temp.size() * 2;
                    temp.add(1000000);
                    break;
                }
                temp.add(t);
            }
            temp.add(1);
            list = temp;
        }
        System.out.println(counter);
    }
}
// we can just calculate part of all the combination numbers.
