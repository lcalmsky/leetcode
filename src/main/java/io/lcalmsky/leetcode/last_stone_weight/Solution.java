package io.lcalmsky.leetcode.last_stone_weight;

import java.util.PriorityQueue;

public class Solution {

  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
    for (int stone : stones) {
      queue.offer(stone);
    }
    while (queue.size() >= 2) {
      Integer first = queue.poll();
      Integer second = queue.poll();
      if (first == second) {
        continue;
      }
      queue.offer(first - second);
    }
    return queue.isEmpty() ? 0 : queue.poll();
  }
}