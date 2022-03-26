package io.lcalmsky.leetcode.binary_search;

public class Solution {

  public int search(int[] nums, int target) {
    return search(nums, target, 0, nums.length);
  }

  private int search(int[] nums, int target, int left, int right) {
    if (left >= right) {
      return -1;
    }
    int mid = (left + right) / 2;
    if (nums[mid] == target) {
      return mid;
    }
    if (nums[mid] > target) {
      return search(nums, target, left, mid);
    }
    if (nums[mid] < target) {
      return search(nums, target, mid + 1, right);
    }
    return -1;
  }
}
