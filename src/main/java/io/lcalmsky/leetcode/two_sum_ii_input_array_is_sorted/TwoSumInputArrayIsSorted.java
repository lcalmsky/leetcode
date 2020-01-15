package io.lcalmsky.leetcode.two_sum_ii_input_array_is_sorted;

public class TwoSumInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int sum = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) return new int[]{i + 1, j + 1};
            }
        }
        return null;
    }
}
