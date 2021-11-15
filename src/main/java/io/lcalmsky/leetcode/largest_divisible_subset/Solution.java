package io.lcalmsky.leetcode.largest_divisible_subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public List<Integer> largestDivisibleSubset(int[] nums) {
    Arrays.sort(nums);
    int[] count = new int[nums.length];
    int[] pre = new int[nums.length];
    int max = 0;
    int index = -1;
    for (int i = 0; i < nums.length; i++) {
      count[i] = 1;
      pre[i] = -1;
      for (int j = i - 1; j >= 0; j--) {
        if (nums[i] % nums[j] == 0) {
          if (1 + count[j] > count[i]) {
            count[i] = count[j] + 1;
            pre[i] = j;
          }
        }
      }
      if (count[i] > max) {
        max = count[i];
        index = i;
      }
    }
    List<Integer> result = new ArrayList<>();
    while (index != -1) {
      result.add(nums[index]);
      index = pre[index];
    }
    return result;
  }
}
