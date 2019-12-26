package io.lcalmsky.leetcode.search_in_rotated_sorted_array_ii;

public class SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return target == nums[0];

        int left = 0, right = nums.length - 1, mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) return true;
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else if (nums[left] > nums[mid]) {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            } else left++;
        }
        return false;
    }
}
