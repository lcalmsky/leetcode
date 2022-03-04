package io.lcalmsky.leetcode.champagne_tower;

public class Solution {

  public double champagneTower(int poured, int queryRow, int queryGlass) {
    double[][] dp = new double[101][101];
    dp[0][0] = poured;
    for (int i = 0; i < 100; i++) {
      for (int j = 0; j <= i; j++) {
        if (dp[i][j] > 1) {
          double spilledOver = dp[i][j] - 1;
          dp[i][j] = 1;
          dp[i + 1][j] += 0.5 * spilledOver;
          dp[i + 1][j + 1] += 0.5 * spilledOver;
        }
      }
    }
    return dp[queryRow][queryGlass];
  }
}
