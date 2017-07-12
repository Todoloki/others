import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < numOfCases; i++) {
            long year1 = scanner.nextLong();
            int month1  = scanner.nextInt() - 1;
            int day1 = scanner.nextInt();
            long year2 = scanner.nextLong();
            int month2 = scanner.nextInt() - 1;
            int day2 = scanner.nextInt();
            
            int cur = 1;
            long sum = 0;
            long numOfleapYear = 0;
            if (year1 > 1900) {
                numOfleapYear = (year1 - 1900 - 1) / 4 - (year1 - 1900 - 1) / 100 + (year1 - 1600 - 1) / 400;
            }
            long numOfNotLeapYear = 0;
            if (year1 > 1900) {
                numOfNotLeapYear = (year1 - 1900) - numOfleapYear;
            }
            numOfleapYear *= 366;
            numOfleapYear %= 7;
            numOfNotLeapYear *= 365;
            numOfNotLeapYear %= 7;
            
            sum = numOfleapYear + numOfNotLeapYear;
            sum %= 7;
            
            cur += (int) sum;
            cur %= 7;
            //System.out.println("stat" + " " + month1);
            if (day1 > 1) {
                month1++;
            }
            for (int j = 0; j < month1; j++) {
                if (((year1 % 100 != 0 && year1 % 4 == 0) || (year1 % 400 == 0)) && j == 1) {
                    cur += 29;
                }
                else {
                    cur += days[j];
                }
                cur %= 7;
            }
            if (year1 == year2) {
                int counter = 0;
                for (int j = month1; j <= month2; j++) {
                    if (cur == 0) {
                        counter++;
                    }
                    if (((year1 % 100 != 0 && year1 % 4 == 0) || (year1 % 400 == 0)) && j == 1) {
                        cur += 29;
                    }
                    else {
                        cur += days[j];
                    }
                    cur %= 7;
                }
                System.out.println(counter);
                continue;
            }
            int counter = 0;
            for (int j = month1; j < days.length; j++) {
                if (cur == 0) {
                    // System.out.println(year1 + " " + (j + 1));
                        counter++;
                }
                if (((year1 % 100 != 0 && year1 % 4 == 0) || (year1 % 400 == 0)) && j == 1) {
                    cur += 29;
                }
                else {
                    cur += days[j];
                }
                cur %= 7;
            }
            for (long year = year1 + 1; year < year2; year++) {
                for (int j = 0; j < days.length; j++) {
                    if (cur == 0) {
                        //System.out.println(year + " " + (j + 1));
                        counter++;
                    }
                    if (((year % 100 != 0 && year % 4 == 0) || (year % 400 == 0)) && j == 1) {
                        cur += 29;
                    }
                    else {
                        cur += days[j];
                    }
                    cur %= 7;
                }
            }
            for (int j = 0; j <= month2; j++) {
                if (cur == 0) {
                        counter++;
                    }
                if (((year2 % 100 != 0 && year2 % 4 == 0) || (year2 % 400 == 0)) && j == 1) {
                    cur += 29;
                }
                else {
                    cur += days[j];
                }
                cur %= 7;
            }
            System.out.println(counter);
        }
    }
}
// passed hackerrank
