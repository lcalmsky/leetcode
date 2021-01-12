package io.lcalmsky.leetcode.maximum_average_subarray_i;

import java.util.Arrays;

/**
 * <pre>
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
 *
 * Example 1:
 *
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 *
 * Note:
 *
 * 1 <= k <= n <= 30,000.
 * Elements of the given array will be in the range [-10,000, 10,000].
 * </pre>
 */
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int[] sums = Arrays.copyOf(nums, n);
        for (int i = 1; i < n; ++i) {
            sums[i] = sums[i - 1] + nums[i];
        }
        double max = sums[k - 1];
        for (int i = k; i < n; ++i) {
            max = Math.max(max, (double) sums[i] - sums[i - k]);
        }
        return max / k;
    }
}
