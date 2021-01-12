package io.lcalmsky.leetcode.two_sum_ii_input_array_is_sorted;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int x = numbers[left] + numbers[right];
            if (x < target) ++left;
            else if (x > target) right--;
            else return new int[]{left + 1, right + 1};
        }

        return null;
    }
}
