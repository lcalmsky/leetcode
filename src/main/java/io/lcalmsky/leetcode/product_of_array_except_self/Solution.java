package io.lcalmsky.leetcode.product_of_array_except_self;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] = result[i + 1] * nums[i + 1];
        }
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = result[i] * left;
            left = left * nums[i];
        }
        return result;
    }
}
