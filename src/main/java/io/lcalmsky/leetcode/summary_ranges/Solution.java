package io.lcalmsky.leetcode.summary_ranges;

import java.util.LinkedList;
import java.util.List;

public class Solution {

  public List<String> summaryRanges(int[] nums) {
    LinkedList<String> result = new LinkedList<>();
    int length = nums.length;
    if (length == 0) {
      return result;
    }
    int left = 0;
    for (int i = 1; i < length + 1; i++) {
      if (i == length || nums[i] != nums[i - 1] + 1) {
        if (i - 1 == left) {
          result.add(String.valueOf(nums[left]));
        } else {
          result.add(String.format("%d->%d", nums[left], nums[i - 1]));
        }
        left = i;
      }
    }
    return result;
  }
}