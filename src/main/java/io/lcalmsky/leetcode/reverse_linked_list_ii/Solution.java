package io.lcalmsky.leetcode.reverse_linked_list_ii;

import io.lcalmsky.leetcode.ListNode;

public class Solution {

  public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode result = new ListNode(0);
    result.next = head;
    ListNode prevLeftNode = result;
    for (int i = 0; i < left - 1; i++) {
      prevLeftNode = prevLeftNode.next;
    }
    ListNode leftNode = prevLeftNode.next;
    ListNode rightNode = leftNode;
    for (int i = 0; i < right - left; i++) {
      rightNode = rightNode.next;
    }
    ListNode postRightNode = rightNode.next;
    ListNode previous = prevLeftNode;
    ListNode node = leftNode;
    while (previous != rightNode) {
      ListNode next = node.next;
      node.next = previous;
      previous = node;
      node = next;
    }
    prevLeftNode.next = rightNode;
    leftNode.next = postRightNode;
    return result.next;
  }
}
