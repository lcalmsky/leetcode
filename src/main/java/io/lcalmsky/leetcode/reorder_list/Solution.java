package io.lcalmsky.leetcode.reorder_list;

import io.lcalmsky.leetcode.ListNode;

public class Solution {

  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }
    ListNode previous = null, slow = head, fast = head;
    while (fast != null && fast.next != null) {
      previous = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    previous.next = null;
    ListNode reversedListNode = reverse(slow);
    merge(head, reversedListNode);
  }

  private ListNode reverse(ListNode head) {
    ListNode prev = null, curr = head, next = null;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  private void merge(ListNode listNode, ListNode reversedListNode) {
    while (listNode != null) {
      ListNode n1 = listNode.next, n2 = reversedListNode.next;
      listNode.next = reversedListNode;
      if (n1 == null) {
        break;
      }
      reversedListNode.next = n1;
      listNode = n1;
      reversedListNode = n2;
    }
  }
}