package io.lcalmsky.leetcode.permutations;

import java.util.ArrayList;
import java.util.List;

public class PermutationsTests {
    public static void main(String[] args) {
        System.out.println(new PermutationsTests().permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums, result);
        return result;
    }

    private void helper(int start, int[] nums, List<List<Integer>> result) {
        if (start == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            helper(start + 1, nums, result);
            swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int i, int start) {
        int tmp = nums[i];
        nums[i] = nums[start];
        nums[start] = tmp;
    }
}
