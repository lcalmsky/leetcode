package io.lcalmsky.leetcode.find_k_th_smallest_pair_distance;

import java.util.Arrays;

/**
 * <pre>
 * Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.
 *
 * Example 1:
 * Input:
 * nums = [1,3,1]
 * k = 1
 * Output: 0
 * Explanation:
 * Here are all the pairs:
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * Then the 1st smallest distance pair is (1,1), and its distance is 0.
 * Note:
 * 2 <= len(nums) <= 10000.
 * 0 <= nums[i] < 1000000.
 * 1 <= k <= len(nums) * (len(nums) - 1) / 2.
 * </pre>
 */
public class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int low = 0;
        int high = nums[n - 1] - nums[0];
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (countPairs(nums, mid) >= k) high = mid;
            else low = mid + 1;
        }

        return low;
    }

    private int countPairs(int[] nums, int target) {
        int n = nums.length, count = 0;
        for (int row = 0, col = 1; row < n - 1; row++) {
            while (col < n && nums[col] - nums[row] <= target) col++;
            count += col - row - 1;
        }
        return count;
    }
}
