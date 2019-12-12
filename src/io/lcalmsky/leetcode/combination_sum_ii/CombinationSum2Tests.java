package io.lcalmsky.leetcode.combination_sum_ii;

import java.util.*;

public class CombinationSum2Tests {
    public static void main(String[] args) {
        CombinationSum2Tests combinationSum2Tests = new CombinationSum2Tests();
        System.out.println(combinationSum2Tests.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(combinationSum2Tests.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Set<List<Integer>> result = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        helper(Arrays.stream(candidates).sorted().toArray(), 0, target, 0, list, result);

        return new ArrayList<>(result);
    }

    private void helper(int[] candidates, int start, int target, int sum, List<Integer> list, Set<List<Integer>> result) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(candidates, i + 1, target, sum + candidates[i], list, result);
            list.remove(list.size() - 1);
        }
    }
}
