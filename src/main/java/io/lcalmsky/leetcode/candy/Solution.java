package io.lcalmsky.leetcode.candy;

public class Solution {

  public int candy(int[] ratings) {
    if (ratings == null || ratings.length == 0) {
      return 0;
    }
    int[] candies = new int[ratings.length];
    candies[0] = 1;
    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i] > ratings[i - 1]) {
        candies[i] = candies[i - 1] + 1;
      } else {
        candies[i] = 1;
      }
    }
    int sum = candies[ratings.length - 1];
    for (int i = ratings.length - 2; i >= 0; i--) {
      int current = 1;
      if (ratings[i] > ratings[i + 1]) {
        current = candies[i + 1] + 1;
      }
      sum += Math.max(current, candies[i]);
      candies[i] = current;
    }
    return sum;
  }
}
