import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        String newline = scanner.nextLine();
        for (int i = 0; i < numOfCases; i++) {
            String curCase = scanner.nextLine();
            int product = 1;
            String[] list = curCase.split("\\s+");
            for (int j = 0; j < list.length; j++) {
                String num = list[j];
                if (num.length() == 0) {
                    continue;
                }
                long number = Long.parseLong(num);
                long numOfDigits = 1;
                long numOfNumbers = 9;
                long start = 1;
                while (numOfDigits * numOfNumbers < number) {
                    number -= numOfDigits * numOfNumbers;
                    numOfDigits++;
                    numOfNumbers *= 10;
                    start *= 10;
                }
                number--;
                String s = "" + (number / numOfDigits + start);
                number %= numOfDigits;
                product *= s.charAt((int)number) - '0';
                // System.out.println(product);
            }
            System.out.println(product);
        }
    }
}

// passed hackerrank
// there's a contradiction between nextInt() and nextLine()
// should be dealt with properly
