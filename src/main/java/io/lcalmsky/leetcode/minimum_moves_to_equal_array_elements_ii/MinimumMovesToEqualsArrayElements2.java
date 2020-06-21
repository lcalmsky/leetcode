package io.lcalmsky.leetcode.minimum_moves_to_equal_array_elements_ii;

import java.util.Arrays;

/**
 * <pre>
 * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
 *
 * You may assume the array's length is at most 10,000.
 *
 * Example:
 *
 * Input:
 * [1,2,3]
 *
 * Output:
 * 2
 *
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 *
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * </pre>
 */
public class MinimumMovesToEqualsArrayElements2 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        int sum = 0;
        for (int i : nums) {
            sum += Math.abs(i - mid);
        }
        return sum;
    }
}
