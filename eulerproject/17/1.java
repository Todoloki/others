import java.util.*;
import java.math.*;
public class Solution {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int limit = 1000;
        String[] numbers = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        String[] teens = new String[]{"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = new String[]{"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String hundred = "hundred";
        String thousand = "thousand";
        int sum = 0;
        for (int i = 1; i <= limit; i++) {
            int t = i;
            int d = t / 1000;
            if (d != 0) {
                // one thousand
                sum += 3;
                sum += thousand.length();
                continue;
            }
            d = t / 100;
            if (d == 1) {
                sum += hundred.length();
                sum += numbers[d - 1].length();
            }
            else if (d >= 2) {
                sum += hundred.length();
                sum += numbers[d - 1].length();
            }
            t -= d * 100;
            if (t == 0) {
                continue;
            }
            if (d >= 1)
            sum += "and".length();
            d = t / 10;
            if (d == 1) {
                if (t == 10) {
                    sum += "ten".length();
                    continue;
                }
                else
                sum += teens[t - 11].length();
                continue;
            }
            else if (d >= 2){
                sum += tens[d - 2].length();
            }
            t -= d * 10;
            if (t == 0) {
                continue;
            }
            else {
                sum += numbers[t - 1].length();
            }
            // System.out.println(sum);
        }
        System.out.println(sum);
    }
}
