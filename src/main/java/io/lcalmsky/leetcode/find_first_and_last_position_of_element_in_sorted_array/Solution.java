package io.lcalmsky.leetcode.find_first_and_last_position_of_element_in_sorted_array;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = firstGreaterEqual(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        int end = firstGreaterEqual(nums, target + 1) - 1;
        return new int[]{start, end};
    }

    private int firstGreaterEqual(int[] nums, int target) {
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
