package io.lcalmsky.leetcode.permutations_ii;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsIITests {
    public static void main(String[] args) {
        System.out.println(new PermutationsIITests().permuteUnique(new int[]{1, 1, 2}));
        System.out.println(new PermutationsIITests().permuteUnique(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums, result);
        return new ArrayList<>(result);
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
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (!set.add(nums[i])) continue;
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
