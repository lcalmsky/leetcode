package io.lcalmsky.leetcode.subarray_product_less_than_k;

/**
 * <pre>
 * Your are given an array of positive integers nums.
 *
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
 *
 * Example 1:
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * Note:
 *
 * 0 < nums.length <= 50000.
 * 0 < nums[i] < 1000.
 * 0 <= k < 10^6.
 * </pre>
 */
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int begin = 0, end = 0, product = 1, answer = 0;
        while (end < nums.length) {
            product *= nums[end++];
            while (product >= k && begin < end) product /= nums[begin++];
            answer += end - begin;
        }
        return answer;
    }
}
