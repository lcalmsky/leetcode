package io.lcalmsky.leetcode.search_insert_position;

public class Solution {

  public int searchInsert(int[] nums, int target) {
    if (target < nums[0]) {
      return 0;
    }
    if (target > nums[nums.length - 1]) {
      return nums.length;
    }
    int left = 0, right = nums.length - 1, mid;
    while (left < right) {
      mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      if (target > nums[mid]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }
}
