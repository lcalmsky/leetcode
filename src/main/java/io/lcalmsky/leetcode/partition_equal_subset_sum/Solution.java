package io.lcalmsky.leetcode.partition_equal_subset_sum;

public class Solution {

  public boolean canPartition(int[] nums) {
    if (nums == null || nums.length < 2) {
      return false;
    }
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 2 != 0) {
      return false;
    }
    sum /= 2;
    boolean[] dp = new boolean[sum + 1];
    dp[0] = true;
    for (int i = 1; i < nums.length; i++) {
      int current = nums[i - 1];
      for (int j = sum; j >= current; j--) {
        dp[j] |= dp[j - current];
      }
    }
    return dp[sum];
  }
}
