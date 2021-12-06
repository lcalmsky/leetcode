package io.lcalmsky.leetcode.minimum_cost_to_move_chips_to_the_same_position;

public class Solution {

  public int minCostToMoveChips(int[] position) {
    int numberOfEven = 0, numberOfOdd = 0;
    for (int value : position) {
      if (value % 2 == 0) {
        numberOfEven++;
      } else {
        numberOfOdd++;
      }
    }
    return Math.min(numberOfEven, numberOfOdd);
  }
}
