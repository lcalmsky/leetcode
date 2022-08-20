package io.lcalmsky.leetcode.minimum_number_of_refueling_stops;

public class Solution {

  public int minRefuelStops(int target, int startFuel, int[][] stations) {
    int length = stations.length;
    int[] dp = new int[length + 1];
    dp[0] = startFuel;
    for (int i = 0; i < length; i++) {
      for (int j = i; j >= 0; j--) {
        if (dp[j] >= stations[i][0]) {
          dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
        }
      }
    }
    for (int i = 0; i <= length; i++) {
      if (dp[i] >= target) {
        return i;
      }
    }
    return -1;
  }
}
