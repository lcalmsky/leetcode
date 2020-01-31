package io.lcalmsky.leetcode.minimum_size_subarray_sum;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0, start = 0, result = Integer.MAX_VALUE;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= s) {
                result = Math.min(result, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        if (result == Integer.MAX_VALUE) return 0;
        return result;
    }
}
