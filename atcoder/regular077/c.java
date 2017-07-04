import java.util.*;
public class Solution {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCases = scanner.nextInt();
        int[] array = new int[numOfCases];
        boolean isLeft = true;
        // read all the numbers
        for (int i = 0; i < numOfCases; i++) {
            array[i] = scanner.nextInt();
        }
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int[] output = new int[numOfCases];
        // rearrange the numbers
        // we can know that the last number will be printed first
        // then the number of index one to the last will be printed last
        // the former one will be the second to be printed out
        // rearrange them to be another array
        // print out the array
        // O(n) time
        // O(n) space
        for (int i = numOfCases - 1; i >= 0; i--) {
            if (isLeft) {
                output[leftIndex++] = array[i];
            }
            else {
                output[rightIndex--] = array[i];
            }
            isLeft = !isLeft;
        }
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
    }
}
