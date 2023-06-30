package io.lcalmsky.leetcode.maximum_product_subarray;

public class Solution {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] max = new int[length];
        int[] min = new int[length];
        max[0] = min[0] = nums[0];
        int result = nums[0];

        for (int i = 1; i < length; i++) {
            int num = nums[i];
            if (num > 0) {
                max[i] = Math.max(num, max[i - 1] * num);
                min[i] = Math.min(num, min[i - 1] * num);
            } else {
                max[i] = Math.max(num, min[i - 1] * num);
                min[i] = Math.min(num, max[i - 1] * num);
            }
            result = Math.max(result, max[i]);
        }

        return result;
    }
}
