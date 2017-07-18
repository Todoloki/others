import java.io.*;
import java.util.*;
import java.math.*;
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        for (int i = 0; i < numOfCases; i++) {
            // 
            BigInteger number = new BigInteger(scanner.next());
            BigInteger numberPlusOne = number.add(new BigInteger("1"));
            BigInteger numberMultipliesTwo = number.multiply(new BigInteger("2"));
            BigInteger numberMultipliesTwoPlusOne = numberMultipliesTwo.add(new BigInteger("1"));
            BigInteger sum1 = number.multiply(numberPlusOne);
            sum1 = sum1.multiply(numberMultipliesTwoPlusOne);
            sum1 = sum1.divide(new BigInteger("6"));
            
            BigInteger n = number.subtract(new BigInteger("1"));
            n = n.divide(new BigInteger("2"));
            BigInteger nPlusOne = n.add(new BigInteger("1"));
            BigInteger nMultipliesTwo = n.multiply(new BigInteger("2"));
            BigInteger nMultipliesTwoPluesOne = nMultipliesTwo.add(new BigInteger("1"));
            BigInteger sum2 = n.multiply(nPlusOne);
            sum2 = sum2.multiply(nMultipliesTwoPluesOne);
            sum2 = sum2.divide(new BigInteger("6"));
            sum2 = sum2.multiply(new BigInteger("4"));
            
            BigInteger res1 = sum1.subtract(sum2);
            BigInteger res2 = res1.multiply(new BigInteger("2"));
            res2 = res2.subtract(new BigInteger("1"));
            BigInteger square = number.multiply(number);
            res2 = res2.subtract(square);
            res2 = res2.divide(new BigInteger("2"));
            res2 = res2.multiply(new BigInteger("3"));
            
            BigInteger res = res2.add(res1);
            res = res.mod(new BigInteger("1000000007"));
            System.out.println(res.toString());
        }
    }
}
// passed hackerrank
// since the result will be too large, bigInteger should be used here.
