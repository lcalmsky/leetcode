package io.lcalmsky.leetcode.contiguous_array;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int findMaxLength(int[] nums) {
    Map<Integer, Integer> countToIndex = new HashMap<>();
    countToIndex.put(0, -1);
    int sum = 0;
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i] == 1 ? 1 : -1;
      if (countToIndex.containsKey(sum)) {
        max = Math.max(max, i - countToIndex.get(sum));
      } else {
        countToIndex.put(sum, i);
      }
    }
    return max;
  }
}
