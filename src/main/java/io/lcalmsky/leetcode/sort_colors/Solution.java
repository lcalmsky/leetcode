package io.lcalmsky.leetcode.sort_colors;

public class Solution {
    public void sortColors(int[] nums) {
        int zeroIndex = 0, current = 0, twoIndex = nums.length - 1;
        while (current <= twoIndex) {
            if (nums[current] == 0) {
                swap(nums, current, zeroIndex++);
            } else if (nums[current] == 2) {
                swap(nums, current++, twoIndex--);
            } else {
                current++;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
