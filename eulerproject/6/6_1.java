/**
 * Wanna play splatoon.
 */
import java.util.*;
public class Solution {
    public static void main(String [] args)
    {
        int lastNumber = 100;
        long square = 0;
        for (int i = 0; i < lastNumber; i++) {
            square += i + 1;
        }
        square *= square;
        int sum = 0;
        for (int i = 0; i < lastNumber; i++) {
            sum += (i + 1) * (i + 1);
        }
        System.out.println(square - sum);
    }
}
