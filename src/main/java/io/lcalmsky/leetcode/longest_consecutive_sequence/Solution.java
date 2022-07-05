package io.lcalmsky.leetcode.longest_consecutive_sequence;

import java.util.Arrays;

public class Solution {

  public int longestConsecutive(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    Arrays.sort(nums);
    int longest = 1;
    int current = 1;
    for (int i = 1; i < nums.length; i++) {
      int currentNumber = nums[i];
      int previousNumber = nums[i - 1];
      if (currentNumber == previousNumber) {
        continue;
      }
      if (currentNumber == previousNumber + 1) {
        current += 1;
      } else {
        longest = Math.max(longest, current);
        current = 1;
      }
    }
    return Math.max(longest, current);
  }
}
