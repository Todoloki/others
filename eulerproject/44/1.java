import java.io.*;
import java.util.*;

public class Mysample {
    public static void main(String[] args) {
        // D is also pentagon, so n, m - n * 2, m - n all in this set

        List<Integer> list = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();

        int n = 1;

        while (true) {
            int temp = n * (3 * n - 1) / 2;
            for (int i = 0; i < list.size(); i++) {
                int m = temp - list.get(i);
                int diff = temp - list.get(i) * 2;
                if (diff <= 0) {
                    break;
                }
                if (set.contains(m) && set.contains(diff)) {
                    System.out.println(diff);
                    break;
                }
            }
            list.add(temp);
            set.add(temp);
            n++;
        }


    }
}
