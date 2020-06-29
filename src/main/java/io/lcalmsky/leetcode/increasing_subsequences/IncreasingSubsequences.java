package io.lcalmsky.leetcode.increasing_subsequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <pre>
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2.
 *
 * Example:
 *
 * Input: [4, 6, 7, 7]
 * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 *
 *
 * Constraints:
 *
 * The length of the given array will not exceed 15.
 * The range of integer in the given array is [-100,100].
 * The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
 * </pre>
 */
public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> answer = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        return new ArrayList<>(backtracking(nums, 0, list, answer));
    }

    private Set<List<Integer>> backtracking(int[] nums, int start, List<Integer> list, Set<List<Integer>> answer) {
        if (list.size() >= 2) {
            answer.add(new ArrayList<>(list));
        }
        for (int i = start; i < nums.length; i++) {
            if (list.size() == 0 || list.get(list.size() - 1) <= nums[i]) {
                list.add(nums[i]);
                backtracking(nums, i + 1, list, answer);
                list.remove(list.size() - 1);
            }
        }
        return answer;
    }
}
