package io.lcalmsky.leetcode.missing_number;

public class Solution {

  public int missingNumber(int[] nums) {
    int numbers = nums.length;
    int sum = numbers * (numbers + 1) / 2;
    for (int num : nums) {
      sum -= num;
    }
    return sum;
  }
}
