package io.lcalmsky.leetcode.house_robber_ii;

public class HouseRobber2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int max1 = rob(nums, 0, nums.length - 2);
        int max2 = rob(nums, 1, nums.length - 1);

        return Math.max(max1, max2);
    }

    private int rob(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int[] dp = new int[nums.length];
        dp[left] = nums[left];
        dp[left + 1] = Math.max(nums[left + 1], dp[left]);
        for (int i = left + 2; i <= right; i++) dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        return dp[right];
    }
}
