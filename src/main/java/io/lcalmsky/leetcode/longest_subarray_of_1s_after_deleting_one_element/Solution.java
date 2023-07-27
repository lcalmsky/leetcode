package io.lcalmsky.leetcode.longest_subarray_of_1s_after_deleting_one_element;

public class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0, end = 0, zeroes = 0;
        while (end < nums.length) {
            if (nums[end] == 0) {
                zeroes++;
            }
            end++;
            if (zeroes > 1) {
                if (nums[start] == 0) {
                    zeroes--;
                }
                start++;
            }
        }
        return end - start - 1;
    }
}
