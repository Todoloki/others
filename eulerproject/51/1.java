import java.io.*;
import java.util.*;

public class Mysample {
    public static void main(String[] args) {
        int totalDigits = 2;
        while (true) {
            for (int sameDigits = 1; sameDigits < totalDigits; sameDigits++) {
                int others = totalDigits - sameDigits;
                int base = 1;
                int temp = others;
                while (temp-- != 0) {
                    base *= 10;
                }
                for (int other = base / 10; other < base; other++) {
                    String notSame = "" + other;
                    //if (sameDigits < others) {
                    List<String> selectedPosition = selectFrom(totalDigits, sameDigits);
                    // System.out.println(totalDigits + " " + sameDigits);
                    for (String position : selectedPosition) {
                        // System.out.println(position);
                        List<Integer> counter = new ArrayList<Integer>();
                        for (int same = 0; same <= 9; same++) {
                            boolean[] isSame = new boolean[totalDigits];
                            int index = 0;
                            while (index < position.length()) {
                                isSame[position.charAt(index) - '0'] = true;
                                index++;
                            }
                            index = 0;
                            int notSameIndex = 0;
                            StringBuffer sb = new StringBuffer();

                            while (index < isSame.length) {
                                if (isSame[index]) {
                                    sb.append(same);
                                } else {
                                    sb.append(notSame.charAt(notSameIndex++));
                                }
                                index++;
                            }
                            if (sb.charAt(0) == '0') {
                                continue;
                            }
                            int num = Integer.parseInt(sb.toString());
                            if (isPrime(num)) {
                                counter.add(num);
                            }

                        }
                        if (counter.size() == 8) {
                            Collections.sort(counter);
                            System.out.println(counter.get(0));
                            return;
                        }
                    }
                    //}
                }
            }
            totalDigits++;
        }
    }
    public static List<String> selectFrom(int total, int select) {
        List<String> list = new ArrayList<String>();
        getPositions(list, 0, total, select, "");

        return list;
    }
    public static void getPositions(List<String> list, int curNumber, int total, int select, String s) {
        if (s.length() == select) {
            list.add(s);
            return ;
        }
        for (int i = curNumber; i < total; i++) {
            getPositions(list, i + 1, total, select, s + i);
        }
    }
    public static boolean isPrime(int n) {
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        int k = 6;
        while (k - 1 <= (int) Math.floor(Math.sqrt(n))) {
            if (n % (k - 1) == 0) {
                return false;
            }
            if (n % (k + 1) == 0) {
                return false;
            }
            k += 6;
        }
        return true;
    }
}
