package io.lcalmsky.leetcode.max_number_of_k_sum_pairs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int maxOperations(int[] nums, int k) {
        if (nums.length == 1) {
            return 0;
        }
        int operations = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            int temp = k - num;
            if (countMap.containsKey(num)) {

            }
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        return operations;
    }

    public static void main(String[] args) {
        int i = new Solution2().maxOperations(new int[]{4, 4, 1, 3, 1, 3, 2, 2, 5, 5, 1, 5, 2, 1, 2, 3, 5, 4}, 2);
        System.out.println(i);
    }
}
