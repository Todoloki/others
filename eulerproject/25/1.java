import java.util.*;
import java.math.*;
import java.io.*;

public class Mysample {
    public static void main(String [] args) {
        int numOfDigits = 1000;

        int[] fab1 = new int[]{1};
        int[] fab2 = new int[]{1};
        int[] fab3 = new int[]{2};
        int index = 3;
        while (fab3.length < numOfDigits) {
            index++;
            fab1 = fab2;
            fab2 = fab3;
            fab3 = new int[fab2.length];
            int c = 0;
            for (int i = 0; i < fab2.length; i++) {
                int d1 = i < fab1.length ? fab1[i] : 0;
                int d2 = fab2[i];
                int sum = d1 + d2 + c;
                c = sum / 10;
                sum %= 10;
                fab3[i] = sum;
            }
            if (c != 0) {
                int[] temp = new int[fab3.length + 1];
                for (int i = 0; i < fab3.length; i++) {
                    temp[i] = fab3[i];
                }
                temp[temp.length - 1] = 1;
                fab3 = temp;
            }
        }
        System.out.println(index);
    }
}
