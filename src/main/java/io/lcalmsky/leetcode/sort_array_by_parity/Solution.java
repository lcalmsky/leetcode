package io.lcalmsky.leetcode.sort_array_by_parity;

public class Solution {

  public int[] sortArrayByParity(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      if (nums[left] % 2 > nums[right] % 2) {
        swap(nums, left, right);
      }
      if (nums[left] % 2 == 0) {
        left++;
      }
      if (nums[right] % 2 == 1) {
        right--;
      }
    }
    return nums;
  }

  private void swap(int[] nums, int left, int right) {
    int temp = nums[left];
    nums[left] = nums[right];
    nums[right] = temp;
  }
}
