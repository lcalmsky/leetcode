package io.lcalmsky.leetcode.partition_equal_subset_sum;

/**
 * <pre>
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Note:
 *
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 *
 *
 * Example 1:
 *
 * Input: [1, 5, 11, 5]
 *
 * Output: true
 *
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 *
 * Example 2:
 *
 * Input: [1, 2, 3, 5]
 *
 * Output: false
 *
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * </pre>
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        int row = nums.length + 1;
        int col = sum + 1;
        boolean[][] cache = new boolean[row][col];
        cache[0][0] = true;
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (cache[i - 1][j] || (j - nums[i - 1] >= 0 && cache[i - 1][j - nums[i - 1]])) { // the i-th element is nums[i-1] here
                    cache[i][j] = true;
                }
            }
        }
        return cache[row - 1][col - 1];
    }
}
