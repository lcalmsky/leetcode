package io.lcalmsky.leetcode.longest_increasing_path_in_a_matrix;

public class Solution {

  private static final int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    int result = 1;
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        result = Math.max(result, dfs(matrix, dp, i, j));
      }
    }
    return result;
  }

  private int dfs(int[][] matrix, int[][] dp, int i, int j) {
    if (dp[i][j] > 0) {
      return dp[i][j];
    }
    int max = 1;
    for (int[] direction : DIRECTIONS) {
      int x = i + direction[0];
      int y = j + direction[1];
      if (!isInBoundary(matrix, x, y) || matrix[x][y] <= matrix[i][j]) {
        continue;
      }
      max = Math.max(max, 1 + dfs(matrix, dp, x, y));
    }
    return dp[i][j] = max;
  }

  private boolean isInBoundary(int[][] matrix, int x, int y) {
    return x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length;
  }
}
