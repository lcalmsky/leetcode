package io.lcalmsky.leetcode.richest_customer_wealth;

public class Solution {
  public int maximumWealth(int[][] accounts) {
    int max = -1, sum;
    for (int[] account : accounts) {
      sum = 0;
      for (int wealth : account) {
        sum += wealth;
      }
      max = Math.max(max, sum);
    }
    return max;
  }
}
