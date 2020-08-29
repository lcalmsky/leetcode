package io.lcalmsky.leetcode.valid_triangle_number;

import java.util.Arrays;

public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = 0, length = nums.length;

        for (int i = 0; i < length; ++i) {
            for (int j = i + 1; j < length; ++j) {
                int sum = nums[i] + nums[j], left = j + 1, right = length;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] < sum) left = mid + 1;
                    else right = mid;
                }
                result += right - 1 - j;
            }
        }
        return result;
    }
}
