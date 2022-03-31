package io.lcalmsky.leetcode.split_array_largest_sum;

public class Solution {

  public int splitArray(int[] nums, int m) {
    int max = 0;
    long sum = 0;
    for (int num : nums) {
      max = Math.max(num, max);
      sum += num;
    }
    if (m == 1) {
      return (int) sum;
    }
    long left = max;
    long right = sum;
    while (left <= right) {
      long mid = (left + right) / 2;
      if (valid(mid, nums, m)) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return (int) left;
  }

  public boolean valid(long target, int[] nums, int m) {
    int count = 1;
    long total = 0;
    for (int num : nums) {
      total += num;
      if (total > target) {
        total = num;
        count++;
        if (count > m) {
          return false;
        }
      }
    }
    return true;
  }
}
