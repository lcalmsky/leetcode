package io.lcalmsky.leetcode.max_number_of_k_sum_pairs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int maxOperations(int[] nums, int k) {
    int operations = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int key = entry.getKey();
      if (key > (k / 2)) {
        continue;
      }
      int value = entry.getValue();
      int remain = k - key;
      if (key == remain) {
        operations += (value / 2);
        continue;
      }
      Integer pairCount = map.get(remain);
      if (pairCount != null) {
        operations += Math.min(value, pairCount);
      }
    }
    return operations;
  }
}

class AnotherSolution extends Solution {

  @Override
  public int maxOperations(int[] nums, int k) {
    Arrays.sort(nums);
    int left = 0;
    int right = nums.length - 1;
    int operations = 0;
    while (left < right) {
      int sum = nums[left] + nums[right];
      if (sum == k) {
        operations++;
        left++;
        right--;
      } else if (sum > k) {
        right--;
      } else {
        left++;
      }
    }
    return operations;
  }
}