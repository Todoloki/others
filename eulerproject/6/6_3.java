import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            long max = n;
            long sumOfSquare = (1 + max) * (2 * max + 1) * max / 6;
            long squareOfSum = (1 + max) * max / 2;
            squareOfSum *= squareOfSum;
            System.out.println(squareOfSum - sumOfSquare);
        }
    }
}

// passed hackerrank
// bug : square of sum is larger than sum of square
