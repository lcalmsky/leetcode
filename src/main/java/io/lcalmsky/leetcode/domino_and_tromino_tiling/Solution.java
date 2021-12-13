package io.lcalmsky.leetcode.domino_and_tromino_tiling;

public class Solution {

  private static final int MODULO = 1000000007;

  public int numTilings(int n) {
    long[][] dp = new long[n + 1][2];
    dp[0][0] = 1;
    dp[1][0] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i][0] = (dp[i - 2][0] + dp[i - 1][0] + 2 * dp[i - 1][1]) % MODULO;
      dp[i][1] = (dp[i - 2][0] + dp[i - 1][1]) % MODULO;
    }
    return (int) dp[n][0];
  }
}

class EnhancedSolution extends Solution {

  private static final int MOD = (int) (1e9 + 7);

  public int numTilings(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    if (n == 3) {
      return 5;
    }
    int a = 1;
    int b = 2;
    int c = 5;
    for (int i = 4; i <= n; i++) {
      int tmp = (2 * c) % MOD + a;
      a = b;
      b = c;
      c = tmp;
      b %= MOD;
      c %= MOD;
    }
    return c;
  }
}