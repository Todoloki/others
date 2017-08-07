import java.io.*;
import java.util.*;
import java.util.stream.*;
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.print(LongStream.rangeClosed(1, N).map(Solution::power).reduce(0, Solution::add));
        scanner.close();
    }
    public static long power(long n) {
        long base = n;
        long power = n;
        long result = 1;
        while (power != 0) {
            if (power % 2 == 1) {
                result = multiply(result, base);
                result %= 10000000000L;
            }
            base = multiply(base, base);
            power /= 2;
        }
        return result;
    }
    public static long multiply(long a, long b) {
        long sum = 0;
        while (b != 0) {
            sum += a * (b % 10);
            sum %= 10000000000L;
            b /= 10;
            a *= 10;
            a %= 10000000000L;
        }
        return sum;
    }
    public static long add(long a, long b) {
        return (a + b) % 10000000000L;
    }
}
// refer to https://github.com/yuechi/projecteuler
// use map reduce
// amazing
