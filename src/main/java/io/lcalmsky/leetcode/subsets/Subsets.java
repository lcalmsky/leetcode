package io.lcalmsky.leetcode.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, result, subset, 0);
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> subset, int start) {
        result.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            dfs(nums, result, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}