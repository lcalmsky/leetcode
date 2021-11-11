package io.lcalmsky.leetcode.minimum_value_to_get_positive_step_by_step_sum;

public class Solution {

  public int minStartValue(int[] nums) {
    int lowestSum = 0;
    int sum = 0;
    for (int num : nums) {
      sum += num;
      lowestSum = Math.min(sum, lowestSum);
    }
    return Math.abs(lowestSum) + 1;
  }
}