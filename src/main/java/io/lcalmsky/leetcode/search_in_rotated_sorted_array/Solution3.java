package io.lcalmsky.leetcode.search_in_rotated_sorted_array;

public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(solution3.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(solution3.search(new int[]{1, 3}, 1));
        System.out.println(solution3.search(new int[]{1, 3}, 2));
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid])
                return mid;

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
