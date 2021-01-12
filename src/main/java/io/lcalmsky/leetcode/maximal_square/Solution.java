package io.lcalmsky.leetcode.maximal_square;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        int w = matrix.length, h = matrix[0].length, result = 0;

        int[][] dp = new int[w][h];

        for (int i = 0; i < w; i++) {
            dp[i][0] = matrix[i][0] - '0';
            result = Math.max(result, dp[i][0]);
        }

        for (int i = 0; i < h; i++) {
            dp[0][i] = matrix[0][i] - '0';
            result = Math.max(result, dp[0][i]);
        }

        for (int i = 1; i < w; i++) {
            for (int j = 1; j < h; j++) {
                if (matrix[i][j] == '1') {
                    int min = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    dp[i][j] = min + 1;
                    result = Math.max(result, dp[i][j]);
                } else dp[i][j] = 0;
            }
        }

        return result * result;
    }
}
