package io.lcalmsky.leetcode.minimum_moves_to_equal_array_elements_ii;

import java.util.Arrays;

public class Solution {

  public int minMoves2(int[] nums) {
    Arrays.sort(nums);
    int mid = nums[nums.length / 2];
    int sum = 0;
    for (int i : nums) {
      sum += Math.abs(i - mid);
    }
    return sum;
  }
}
