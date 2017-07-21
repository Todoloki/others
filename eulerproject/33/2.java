import java.util.*;
import java.math.*;
import java.io.*;

public class Mysample {
    public static class Pair {
        int x;
        int y;
        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String [] args) {
        int base = 1;
        int N = 4;
        int k = 1;
        long sumOfNumerators = 0;
        long sumOfDenominators = 0;
        for (int i = 0; i < N; i++) {
            base *= 10;
        }
        for (int i = base / 10; i < base; i++) {
            for (int j = i + 1; j < base; j++) {
                List<Pair> list = new ArrayList<Pair>();
                getCanceledPair(list, i, j, k, 0);
                for (Pair p : list) {
                    int gcd = getGCD(p.x, p.y);
                    int tx = p.x / gcd;
                    int ty = p.y / gcd;
                    gcd = getGCD(i, j);
                    int ti = i / gcd;
                    int tj = j / gcd;
                    if (tx == ti && ty == tj) {
                        sumOfNumerators += i;
                        sumOfDenominators += j;
                        break;
                    }
                }
            }
        }
        System.out.println(sumOfNumerators + " " + sumOfDenominators);
    }
    public static void getCanceledPair(List<Pair> list, int i, int j, int target, int curCanceled) {
        if (curCanceled == target) {
            list.add(new Pair(i, j));
            return ;
        }
        List<Integer> listI = new ArrayList<Integer>();
        List<Integer> listJ = new ArrayList<Integer>();
        int temp = i;
        while (temp != 0) {
            int d = temp % 10;
            temp /= 10;
            listI.add(d);
        }
        temp = j;
        while (temp != 0) {
            int d = temp % 10;
            temp /= 10;
            listJ.add(d);
        }
        Collections.reverse(listI);
        Collections.reverse(listJ);
        for (int i1 = 0; i1 < listI.size(); i1++) {
            for (int j1 = 0; j1 < listJ.size(); j1++) {
                if (listI.get(i1) == listJ.get(j1) && listI.get(i1) != 0) {
                    int ti = 0;
                    for (int ki = 0; ki < listI.size(); ki++) {
                        if (ki == i1) {
                            continue;
                        }
                        ti *= 10;
                        ti += listI.get(ki);
                    }
                    int tj = 0;
                    for (int kj = 0; kj < listJ.size(); kj++) {
                        if (kj == j1) {
                            continue;
                        }
                        tj *= 10;
                        tj += listJ.get(kj);
                    }
                    getCanceledPair(list, ti, tj, target, curCanceled + 1);
                }
            }
        }
    }
    public static int getGCD(int a, int b) {
        if (a <= 1 || b <= 1) {
            return 1;
        }
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (a % b == 0) {
            return b;
        }
        return getGCD(b, a % b);
    }
}
