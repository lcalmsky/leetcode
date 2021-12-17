package io.lcalmsky.leetcode.maximal_square;

public class Solution {

  public int maximalSquare(char[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    int width = matrix.length, height = matrix[0].length, result = 0;
    int[][] dp = new int[width][height];
    for (int i = 0; i < width; i++) {
      dp[i][0] = matrix[i][0] - '0';
      result = Math.max(result, dp[i][0]);
    }
    for (int i = 0; i < height; i++) {
      dp[0][i] = matrix[0][i] - '0';
      result = Math.max(result, dp[0][i]);
    }
    for (int i = 1; i < width; i++) {
      for (int j = 1; j < height; j++) {
        if (matrix[i][j] == '0') {
          dp[i][j] = 0;
          continue;
        }
        int min = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
        dp[i][j] = min + 1;
        result = Math.max(result, dp[i][j]);
      }
    }
    return result * result;
  }
}
