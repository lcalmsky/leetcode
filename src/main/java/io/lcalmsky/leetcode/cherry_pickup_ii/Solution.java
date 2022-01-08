package io.lcalmsky.leetcode.cherry_pickup_ii;

public class Solution {

  public int cherryPickup(int[][] grid) {
    int height = grid.length;
    int width = grid[0].length;
    int[][][] dpCache = new int[height][width][width];
    initialize(height, width, dpCache);
    return dp(0, 0, width - 1, grid, dpCache);
  }

  private void initialize(int height, int width, int[][][] dpCache) {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        for (int k = 0; k < width; k++) {
          dpCache[i][j][k] = -1;
        }
      }
    }
  }

  private int dp(int row, int col1, int col2, int[][] grid, int[][][] dpCache) {
    if (col1 < 0 || col1 >= grid[0].length || col2 < 0 || col2 >= grid[0].length) {
      return 0;
    }
    if (dpCache[row][col1][col2] != -1) {
      return dpCache[row][col1][col2];
    }
    int result = grid[row][col1];
    if (col1 != col2) {
      result += grid[row][col2];
    }
    if (row != grid.length - 1) {
      int max = 0;
      for (int newCol1 = col1 - 1; newCol1 <= col1 + 1; newCol1++) {
        for (int newCol2 = col2 - 1; newCol2 <= col2 + 1; newCol2++) {
          max = Math.max(max, dp(row + 1, newCol1, newCol2, grid, dpCache));
        }
      }
      result += max;
    }
    dpCache[row][col1][col2] = result;
    return result;
  }
}