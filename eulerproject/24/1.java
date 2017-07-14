import java.util.*;
import java.math.*;
import java.io.*;

public class Mysample {
    public static void main(String [] args) {
        long order = 1000000;
        order--;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <= 9; i++) {
            list.add(i);
        }
        StringBuffer sb = new StringBuffer();
        long curBase = 1;
        for (int i = 1; i <= 9; i++) {
            curBase *= i;
        }
        long curDivisor = 9;
        while (list.size() > 1) {
            int index = (int)(order / curBase);
            sb.append(list.get(index));
            list.remove(index);
            order %= curBase;
            if (curDivisor > 0) {
                curBase /= curDivisor;
                curDivisor--;
            }
        }
        System.out.println(sb.toString());
    }
}

// first 9! permutation start with 0 and so one
// each time we decide next number in the permutation.
