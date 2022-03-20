package io.lcalmsky.leetcode.minimum_domino_rotations_for_equal_row;

public class Solution {

  public int minDominoRotations(int[] tops, int[] bottoms) {
    for (int i = 1; i <= 6; i++) {
      int result = check(tops, bottoms, i);
      if (result != -1) {
        return result;
      }
    }
    return -1;
  }

  private int check(int[] tops, int[] bottoms, int number) {
    int countTop = 0, countBottom = 0;
    for (int i = 0; i < tops.length; i++) {
      if (tops[i] != number && bottoms[i] != number) {
        return -1;
      }
      if (tops[i] != number) {
        countTop++;
      } else if (bottoms[i] != number) {
        countBottom++;
      }
    }
    return Math.min(countTop, countBottom);
  }
}
