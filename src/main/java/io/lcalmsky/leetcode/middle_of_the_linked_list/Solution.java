package io.lcalmsky.leetcode.middle_of_the_linked_list;

import io.lcalmsky.leetcode.ListNode;

public class Solution {

  public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return fast.next == null ? slow : slow.next;
  }
}
