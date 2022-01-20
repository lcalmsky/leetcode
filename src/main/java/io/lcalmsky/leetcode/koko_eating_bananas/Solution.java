package io.lcalmsky.leetcode.koko_eating_bananas;

public class Solution {

  public int minEatingSpeed(int[] piles, int h) {
    int low = 1;
    int max = 1;
    for (int pile : piles) {
      max = Math.max(pile, max);
    }
    while (low < max) {
      int mid = (max - low) / 2 + low;
      int current = 0;
      for (int pile : piles) {
        current += (pile % mid == 0) ? pile / mid : pile / mid + 1;
      }
      if (current > h) {
        low = mid + 1;
      } else {
        max = mid;
      }
    }
    return low;
  }
}
