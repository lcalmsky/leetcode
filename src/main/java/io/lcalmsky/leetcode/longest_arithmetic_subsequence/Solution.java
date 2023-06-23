package io.lcalmsky.leetcode.longest_arithmetic_subsequence;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestArithSeqLength(int[] nums) {

        int n = nums.length;
        int maxLength = 0;

        Map<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                int length = dp[j].getOrDefault(diff, 1) + 1;
                dp[i].put(diff, length);
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}
