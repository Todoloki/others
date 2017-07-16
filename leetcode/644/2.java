public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double minValue = nums[0];
        double maxValue = nums[0];
        // find the minimum and maximum value in this array
        for (int i = 0; i < nums.length; i++) {
            minValue = Math.min(minValue, nums[i]);
            maxValue = Math.max(maxValue, nums[i]);
            
        }
        double mid = 0.0;
        double prevmid = minValue;
        double error = 1.0;
        while (error > 1e-5) {
            mid = (minValue + maxValue) / 2;
            // System.out.println(mid);
            if (check(nums, mid, k)) {
                minValue = mid;
            }
            else {
                maxValue = mid;
            }
            error = Math.abs(mid - prevmid);
            prevmid = mid;
        }
        return minValue;
    }
    
    public boolean check(int[] nums, double average, int k) {
        double sum = 0.0;
        for (int i = 0; i < k; i++) {
            sum += nums[i] - average;
        }
        if (sum >= 0) {
            return true;
        }
        double prevSum = 0.0;
        double minPrev = 0.0;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - average;
            prevSum += nums[i - k] - average;
            minPrev = Math.min(minPrev, prevSum);
            if (sum >= minPrev) {
                return true;
            }
        }
        return false;
    }
}

// binary search 
// need to be careful
// set minPrev to be 0.0 otherwise we cannot check for cases where the most first k + 1 numbers is the answer.
