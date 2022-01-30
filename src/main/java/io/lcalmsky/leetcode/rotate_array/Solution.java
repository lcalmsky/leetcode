package io.lcalmsky.leetcode.rotate_array;

public class Solution {

  public void rotate(int[] nums, int k) {
    int length = nums.length;
    if (k > length) {
      k = k % length;
    }
    int index = length - k;
    reverse(nums, 0, index - 1);
    reverse(nums, index, length - 1);
    reverse(nums, 0, length - 1);
  }

  private void reverse(int[] nums, int left, int right) {
    if (nums == null || nums.length == 1) {
      return;
    }
    while (left < right) {
      int temp = nums[left];
      nums[left] = nums[right];
      nums[right] = temp;
      left++;
      right--;
    }
  }
}
