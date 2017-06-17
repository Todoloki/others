/**
 * Wanna play splatoon.
 */
import java.util.*;
public class Solution {
    public static void main(String [] args)
    {
        int lastNumber = 100;
        long sumOfSquare = lastNumber * (2 * lastNumber + 1) * (lastNumber + 1) / 6;
        long squareOfSum = (1 + lastNumber) * lastNumber / 2;
        squareOfSum *= squareOfSum;
        System.out.println(squareOfSum - sumOfSquare);
    }
}
// use formula instead of calculate using brute force
// much faster from O(n) to O(1)
