package io.lcalmsky.leetcode.sort_array_by_parity_ii;

public class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0 && nums[i] % 2 == 0) {
                continue;
            }
            if (i % 2 == 1 & nums[i] % 2 == 1) {
                continue;
            }
            if (i % 2 == 0 && nums[i] % 2 == 1) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] % 2 == 0) {
                        swap(nums, i, j);
                        break;
                    }
                }
            } else {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] % 2 == 1) {
                        swap(nums, i, j);
                        break;
                    }
                }
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

class BetterSolution extends Solution {
    @Override
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int even = 0, odd = 1;
        while (even < n && odd < n) {
            while (even < n && (nums[even] & 1) == 0) {
                even += 2;
            }
            while (odd < n && (nums[odd] & 1) != 0) {
                odd += 2;
            }
            if (even < n && odd < n) {
                swap(nums, odd, even);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}