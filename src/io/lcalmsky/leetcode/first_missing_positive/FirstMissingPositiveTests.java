package io.lcalmsky.leetcode.first_missing_positive;

import java.util.Arrays;

public class FirstMissingPositiveTests {
    public static void main(String[] args) {
        FirstMissingPositiveTests firstMissingPositiveTests = new FirstMissingPositiveTests();
        System.out.println(firstMissingPositiveTests.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositiveTests.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositiveTests.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println(firstMissingPositiveTests.firstMissingPositive(new int[]{0, 1, 1, 2, 2}));
    }

    public int firstMissingPositive(int[] nums) {

        if (nums == null || nums.length == 0) return 1;

        nums = Arrays.stream(nums).distinct().sorted().toArray();

        if (nums[0] > 1) return 1;
        if (nums[nums.length - 1] < 1) return 1;

        int positiveIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                positiveIdx = i;
                break;
            }
        }

        if (nums[positiveIdx] > 1) return 1;

        for (int i = positiveIdx + 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) return nums[i - 1] + 1;
        }

        return nums[nums.length - 1] + 1;
    }
}
