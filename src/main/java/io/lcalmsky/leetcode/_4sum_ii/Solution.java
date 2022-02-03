package io.lcalmsky.leetcode._4sum_ii;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    Map<Integer, Integer> map = new HashMap<>();
    int result = 0;
    for (int i : nums1) {
      for (int j : nums2) {
        int sum = i + j;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
      }
    }
    for (int i : nums3) {
      for (int j : nums4) {
        int sum = i + j;
        if (map.containsKey(-sum)) {
          result += map.get(-sum);
        }
      }
    }
    return result;
  }
}
