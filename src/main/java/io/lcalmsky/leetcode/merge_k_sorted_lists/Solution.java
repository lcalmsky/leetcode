package io.lcalmsky.leetcode.merge_k_sorted_lists;

import io.lcalmsky.leetcode.ListNode;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
    ListNode head = new ListNode(0);
    ListNode current = head;
    for (ListNode list : lists) {
      if (list != null) {
        queue.offer(list);
      }
    }
    while (!queue.isEmpty()) {
      ListNode node = queue.poll();
      current.next = node;
      current = current.next;
      if (node.next != null) {
        queue.offer(node.next);
      }
    }
    return head.next;
  }
}
