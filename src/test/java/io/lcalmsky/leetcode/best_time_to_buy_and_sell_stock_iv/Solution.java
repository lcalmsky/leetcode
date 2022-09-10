package io.lcalmsky.leetcode.best_time_to_buy_and_sell_stock_iv;

public class Solution {

  public int maxProfit(int k, int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    int n = prices.length;
    if (k >= n / 2) {
      int maxProfit = 0;
      for (int i = 1; i < n; i++) {
        if (prices[i] > prices[i - 1]) {
          maxProfit += prices[i] - prices[i - 1];
        }
      }
      return maxProfit;
    }
    int[][] dp = new int[k + 1][prices.length];
    for (int i = 1; i <= k; i++) {
      int localMax = -prices[0];
      for (int j = 1; j < prices.length; j++) {
        dp[i][j] = Math.max(dp[i][j - 1], prices[j] + localMax);
        localMax = Math.max(localMax, dp[i - 1][j] - prices[j]);
      }
    }
    return dp[k][prices.length - 1];
  }
}
