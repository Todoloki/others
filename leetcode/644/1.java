public class Solution {
    public double findMaxAverage(int[] nums, int k) {
         double max = 0;
        boolean maxSet = false;
         for (int i = 0; i < nums.length; i++) {
             double temp = 0.0;
             for (int j = i; j < nums.length; j++) {
                 temp += nums[j];
                 if (j - i + 1 >= k) {
                     if (maxSet == false) {
                         maxSet = true;
                         max = temp / (j - i + 1);
                     }
                     else {
                         max = Math.max(max, temp / (j - i + 1));
                     }
                 }
             }
         }
        return max;
    }
}
// brute force O(n ^ 2) time O(1) space
