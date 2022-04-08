package io.lcalmsky.leetcode.kth_largest_element_in_a_stream;

import java.util.PriorityQueue;

public class KthLargest {

  private final PriorityQueue<Integer> queue;
  private final int k;

  public KthLargest(int k, int[] nums) {
    queue = new PriorityQueue<>();
    this.k = k;
    for (int num : nums) {
      queue.offer(num);
      if (queue.size() > k) {
        queue.poll();
      }
    }
  }

  public int add(int val) {
    queue.offer(val);
    if (queue.size() > k) {
      queue.poll();
    }
    return queue.peek();
  }
}
