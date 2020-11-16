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
public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        long sum = 0;
        for (int num : nums) sum += num;
        if (sum % k == 0) {
            boolean[] visited = new boolean[nums.length];
            return canPartition(nums, 0, 0, 0, sum / k, k, visited);
        }
        return false;
    }

    private boolean canPartition(int[] nums, int index, int currSum, int currCount, long target, int k, boolean[] visited) {
        if (k == 1) return true;
        if (currSum == target && currCount > 0) return canPartition(nums, 0, 0, 0, target, k - 1, visited);

        for (int i = index; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (canPartition(nums, i + 1, currSum + nums[i], currCount + 1, target, k, visited)) return true;
                visited[i] = false;
            }
        }
        return false;
    }
}

//class AnotherSolution {
//    public boolean canPartitionKSubsets(int[] nums, int k) {
//        int sum = 0;
//        Map<Integer, Integer> countMap = new HashMap<>();
//        for (int num : nums) {
//            sum += num;
//            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
//        }
//        if (sum % k != 0) return false;
//        int target = sum / k;
//        int count = 0;
//        Arrays.sort(nums);
//        for (int i = nums.length - 1; i >= 0; i--) {
//        }
//
//        return false;
//    }
//}
