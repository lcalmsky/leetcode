package io.lcalmsky.leetcode.kth_largest_element_in_an_array;

import java.util.Arrays;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
