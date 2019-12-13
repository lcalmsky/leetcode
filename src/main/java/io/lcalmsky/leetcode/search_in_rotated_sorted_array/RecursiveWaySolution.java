package io.lcalmsky.leetcode.search_in_rotated_sorted_array;

public class RecursiveWaySolution {

    public static void main(String[] args) {
        RecursiveWaySolution recursiveWaySolution = new RecursiveWaySolution();
        System.out.println(recursiveWaySolution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(recursiveWaySolution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(recursiveWaySolution.search(new int[]{1, 3}, 1));
        System.out.println(recursiveWaySolution.search(new int[]{1, 3}, 2));
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right)
            return -1;

        int mid = left + (right - left) / 2;

        if (target == nums[mid])
            return mid;

        if (nums[left] <= nums[mid]) {
            if (nums[left] <= target && target < nums[mid]) {
                return binarySearch(nums, left, mid - 1, target);
            } else {
                return binarySearch(nums, mid + 1, right, target);
            }
        } else {
            if (nums[mid] < target && target <= nums[right]) {
                return binarySearch(nums, mid + 1, right, target);
            } else {
                return binarySearch(nums, left, mid - 1, target);
            }
        }
    }
}
