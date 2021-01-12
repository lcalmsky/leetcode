package io.lcalmsky.leetcode.maximum_gap;

import java.util.Arrays;

public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        Arrays.sort(nums);

        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], Math.abs(nums[i] - nums[i - 1]));
        }

        return dp[nums.length - 1];
    }
}
