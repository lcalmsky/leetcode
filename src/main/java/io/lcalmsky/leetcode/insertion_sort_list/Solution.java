package io.lcalmsky.leetcode.insertion_sort_list;

import io.lcalmsky.leetcode.ListNode;

public class Solution {

  public ListNode insertionSortList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode result = new ListNode(0);
    ListNode previous = result;
    ListNode current = head;
    ListNode next;
    while (current != null) {
      next = current.next;
      while (previous.next != null && previous.next.val < current.val) {
        previous = previous.next;
      }
      current.next = previous.next;
      previous.next = current;
      previous = result;
      current = next;
    }
    return result.next;
  }
}
