package io.lcalmsky.leetcode.matchsticks_to_square;

import java.util.Arrays;

public class Solution {

  public boolean makesquare(int[] nums) {
    if (nums.length == 0) {
      return false;
    }
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 4 != 0) {
      return false;
    }
    Arrays.sort(nums);
    return dfs(nums, nums.length - 1, sum / 4, new int[4]);
  }

  private boolean dfs(int[] nums, int index, int side, int[] sides) {
    if (index < 0) {
      return sides[0] == side && sides[1] == side && sides[2] == side && sides[3] == side;
    }
    for (int i = 0; i < sides.length; i++) {
      if (sides[i] + nums[index] > side) {
        continue;
      }
      sides[i] += nums[index];
      if (dfs(nums, index - 1, side, sides)) {
        return true;
      }
      sides[i] -= nums[index];
    }
    return false;
  }
}
