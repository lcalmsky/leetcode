package io.lcalmsky.leetcode.find_all_numbers_disappeared_in_an_array;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 * </pre>
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) nums[val] = -nums[val];
        }
        for (int i = 0; i < length; i++) if (nums[i] > 0) result.add(i + 1);
        return result;
    }
    /*public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        boolean[] exist = new boolean[nums.length + 1];
        for (int num : nums) exist[num] = true;
        for (int i = 1; i < exist.length; i++) if (!exist[i]) result.add(i);
        return result;
    }*/
}
