package io.lcalmsky.leetcode.max_consecutive_ones_iii;

public class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0, end = 0, zeroes = 0;
        while (end < nums.length) {
            if (nums[end] == 0) {
                zeroes++;
            }
            end++;
            if (zeroes > k) {
                if (nums[start] == 0) {
                    zeroes--;
                }
                start++;
            }
        }
        return end - start;
    }
}
