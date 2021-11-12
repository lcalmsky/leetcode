package io.lcalmsky.leetcode.remove_linked_list_elements;

import io.lcalmsky.leetcode.ListNode;

public class Solution {

  public ListNode removeElements(ListNode head, int val) {
    ListNode root = new ListNode(0);
    root.next = head;
    ListNode current = root;
    while (current.next != null) {
      if (current.next.val != val) {
        current = current.next;
        continue;
      }
      current.next = current.next.next;
    }
    return root.next;
  }
}
