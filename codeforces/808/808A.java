
/**
 * Wanna play splatoon.
 */
import java.util.*;
public class Main {
    public static void main(String [] args)
    {
        Scanner scanner = new Scanner(System.in);
        int currentYear = scanner.nextInt();
        if (currentYear < 9) {
            System.out.println(1);
            return ;
        }
        int base = 10;
        int t = currentYear;
        while (t / base > 9) {
            base *= 10;
        }
        System.out.println(base - (t - t / base * base));
    }
}
/*
given an integer, get the integer which is larger than the current integer and has at most one non zero digit.
Method 1:
  We can increase the integer until we reach such a number. Since the range is up to 10 to the power of nine, we will need to 
  repeat the step at most 10 to the power of nine times.
  Will cost a lot of time.
Method 2:
  We use the rule that if the number is less than 9, then return 1.
  we can calcualte the difference between the current number and next magic number by calcualting the current number without first digit and the minimum value 
  with the same digit as the current number.
  At most several operations are needed.
  So this method is much faster than the former one.
*/
