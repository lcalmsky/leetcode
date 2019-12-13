package io.lcalmsky.leetcode.search_insert_position;

public class SearchInsertPositionTests {
    public static void main(String[] args) {
        SearchInsertPositionTests s = new SearchInsertPositionTests();
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println(s.searchInsert(new int[]{1, 3}, 1));
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(s.searchInsert(new int[]{1, 3}, 2));
    }

    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;

        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}