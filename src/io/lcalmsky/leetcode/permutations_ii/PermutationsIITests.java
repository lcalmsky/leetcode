package io.lcalmsky.leetcode.permutations_ii;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PermutationsIITests {
    public static void main(String[] args) {
        System.out.println(new PermutationsIITests().permuteUnique(new int[]{1, 1, 2}));
        System.out.println(new PermutationsIITests().permuteUnique(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new LinkedHashSet<>();
        helper(0, nums, result);
        return new ArrayList<>(result);
    }

    private void helper(int start, int[] nums, Set<List<Integer>> result) {
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
