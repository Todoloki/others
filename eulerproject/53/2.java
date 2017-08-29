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
                    t = 1000000;
                    counter++;
                }
                temp.add(t);
            }
            temp.add(1);
            list = temp;
        }
        System.out.println(counter);
    }
}
// can use less space since only previous row is used to calculate the next row;
