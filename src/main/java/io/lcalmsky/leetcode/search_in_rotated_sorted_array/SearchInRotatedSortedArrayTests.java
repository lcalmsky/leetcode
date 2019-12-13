package io.lcalmsky.leetcode.search_in_rotated_sorted_array;

public class SearchInRotatedSortedArrayTests {
    public static void main(String[] args) {
        SearchInRotatedSortedArrayTests searchInRotatedSortedArrayTests = new SearchInRotatedSortedArrayTests();
        System.out.println(searchInRotatedSortedArrayTests.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(searchInRotatedSortedArrayTests.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(searchInRotatedSortedArrayTests.search(new int[]{1, 3}, 1));
        System.out.println(searchInRotatedSortedArrayTests.search(new int[]{1, 3}, 2));
    }

    public int search(int[] nums, int target) {
        // null or empty
        if (nums == null || nums.length == 0) return -1;

        // only one element
        if (nums.length == 1) return target == nums[0] ? 0 : -1;

        // find index where value start to decrease
        int idx = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                idx = i + 1;
                break;
            }
        }

        if (nums[idx] == target) return idx;

        // ascending ordered array
        if (idx == 0) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) return i;
            }
            return -1;
        }

        // when target is out of range
        if (target < nums[idx] || target > nums[idx - 1]) return -1;

        if (target >= nums[idx] && target <= nums[nums.length - 1]) {
            for (int i = idx; i < nums.length; i++) {
                if (nums[i] == target) return i;
            }
            return -1;
        }

        if (target <= nums[idx - 1] && target >= nums[0]) {
            for (int i = 0; i < idx; i++) {
                if (nums[i] == target) return i;
            }
            return -1;
        }

        return -1;
    }
}
