package io.lcalmsky.leetcode.range_sum_query_mutable;

public class Solution {

    private final int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public void update(int i, int val) {
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        for (; i <= j; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
