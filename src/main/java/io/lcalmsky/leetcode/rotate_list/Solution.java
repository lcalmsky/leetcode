package io.lcalmsky.leetcode.rotate_list;

import io.lcalmsky.leetcode.ListNode;

public class Solution {

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return null;
    }
    ListNode current = head;
    int size = 1;
    while (current.next != null) {
      size++;
      current = current.next;
    }
    current.next = head;
    current = head;
    int rotate = size - k % size;
    while (rotate-- > 1) {
      current = current.next;
    }
    ListNode result = current.next;
    current.next = null;
    return result;
  }
}
