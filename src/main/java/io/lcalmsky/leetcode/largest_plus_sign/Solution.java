package io.lcalmsky.leetcode.largest_plus_sign;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        Set<Integer> banned = new HashSet<>();
        for (int[] mine : mines) {
            banned.add(mine[0] * n + mine[1]);
        }
        int[][] dp = new int[n][n];
        int count;
        for (int row = 0; row < n; row++) {
            count = 0;
            for (int col = 0; col < n; col++) {
                count = banned.contains(row * n + col) ? 0 : count + 1;
                dp[row][col] = count;
            }
            count = 0;
            for (int col = n - 1; col >= 0; col--) {
                count = banned.contains(row * n + col) ? 0 : count + 1;
                dp[row][col] = Math.min(dp[row][col], count);
            }
        }
        int result = 0;
        for (int col = 0; col < n; col++) {
            count = 0;
            for (int row = 0; row < n; row++) {
                count = banned.contains(row * n + col) ? 0 : count + 1;
                dp[row][col] = Math.min(dp[row][col], count);
            }
            count = 0;
            for (int row = n - 1; row >= 0; row--) {
                count = banned.contains(row * n + col) ? 0 : count + 1;
                dp[row][col] = Math.min(dp[row][col], count);
                result = Math.max(result, dp[row][col]);
            }
        }
        return result;
    }
}
