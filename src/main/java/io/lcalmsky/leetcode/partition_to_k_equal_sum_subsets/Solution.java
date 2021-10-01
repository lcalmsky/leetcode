package io.lcalmsky.leetcode.partition_to_k_equal_sum_subsets;

/**
 * <pre>
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 *
 * Example 1:
 *
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 *
 * Note:
 *
 * 1 <= k <= len(nums) <= 16.
 * 0 < nums[i] < 10000.
 * </pre>
 */
public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        return dfs(nums, 0, 0, 0, sum / k, k, new boolean[nums.length]);
    }

    private boolean dfs(int[] nums, int index, int sum, int count, int target, int k, boolean[] visited) {
        if (k == 1) {
            return true;
        }
        if (sum == target && count > 0) {
            return dfs(nums, 0, 0, 0, target, k - 1, visited);
        }

        for (int i = index; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (dfs(nums, i + 1, sum + nums[i], count + 1, target, k, visited)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}