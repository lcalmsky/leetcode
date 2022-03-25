package io.lcalmsky.leetcode.two_city_scheduling;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

  public int twoCitySchedCost(int[][] costs) {
    PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(x -> (x[1] - x[0])));
    int sum = 0;
    for (int[] cost : costs) {
      sum += cost[0];
      queue.add(cost);
    }
    for (int i = 0; i < costs.length / 2; ++i) {
      int[] poll = queue.poll();
      sum += (poll[1] - poll[0]);
    }
    return sum;
  }
}
