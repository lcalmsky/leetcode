package io.lcalmsky.leetcode.maximum_average_subarray_i;

public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAverage = -10001;
        double localMax = 0;
        for (int i = 0; i < nums.length; i++) {
            localMax += nums[i];
            if (i - k >= -1) {
                maxAverage = Math.max(maxAverage, localMax / k);
                localMax -= nums[i - k + 1];
            }
        }
        return maxAverage;
    }
}
