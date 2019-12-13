package io.lcalmsky.leetcode.find_first_and_last_position_of_element_in_sorted_array;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray f = new FindFirstAndLastPositionOfElementInSortedArray();
        System.out.println(Arrays.toString(f.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(f.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
    }

    public int[] searchRange(int[] nums, int target) {

        int targetIdx = binarySearch(nums, 0, nums.length - 1, target);

        if (targetIdx == -1) return new int[]{-1, -1};

        int firstIdx = 0, lastIdx = 0;
        for (int i = targetIdx; i >= 0; i--) {
            if (nums[i] == target) firstIdx = i;
            else break;
        }
        for (int i = targetIdx; i < nums.length; i++) {
            if (nums[i] == target) lastIdx = i;
            else break;
        }

        return new int[]{firstIdx, lastIdx};
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;

        if (target >= nums[mid]) return binarySearch(nums, mid + 1, right, target);

        else return binarySearch(nums, left, mid - 1, target);
    }
}
