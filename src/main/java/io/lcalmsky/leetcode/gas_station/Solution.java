package io.lcalmsky.leetcode.gas_station;

public class Solution {

  public int canCompleteCircuit(int[] gas, int[] cost) {
    int total = 0, start = 0, remaining = 0;
    for (int i = 0; i < gas.length; i++) {
      int diff = gas[i] - cost[i];
      remaining += diff; // (1)
      total += diff; // (2)
      if (remaining < 0) { // (3)
        remaining = 0;
        start = i + 1;
      }
    }
    return total >= 0 ? start : -1; // (4)
  }
}
