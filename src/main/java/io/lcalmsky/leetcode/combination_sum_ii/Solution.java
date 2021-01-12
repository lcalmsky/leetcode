package io.lcalmsky.leetcode.combination_sum_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(candidates);

        helper(candidates, 0, target, 0, list, result);

        return new ArrayList<>(result);
    }

    private void helper(int[] candidates, int start, int target, int sum, List<Integer> list, List<List<Integer>> result) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        int prev = -1;
        for (int i = start; i < candidates.length; i++) {
            if (prev != candidates[i]) {
                list.add(candidates[i]);
                helper(candidates, i + 1, target, sum + candidates[i], list, result);
                list.remove(list.size() - 1);
                prev = candidates[i];
            }
        }
    }
}
