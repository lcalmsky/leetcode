package io.lcalmsky.leetcode.kth_largest_element_in_an_array;

import java.util.PriorityQueue;

public class Solution {

  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    for (int num : nums) {
      priorityQueue.offer(num);
    }
    while (priorityQueue.size() > k) {
      priorityQueue.poll();
    }
    if (priorityQueue.isEmpty()) {
      throw new IllegalStateException();
    }
    return priorityQueue.poll();
  }
}
