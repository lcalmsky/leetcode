package io.lcalmsky.leetcode.swapping_nodes_in_a_linked_list;

import io.lcalmsky.leetcode.ListNode;

public class Solution {

  public ListNode swapNodes(ListNode head, int k) {
    k = k - 1;
    ListNode forward = head;
    while (k > 0) {
      forward = forward.next;
      k--;
    }
    ListNode remain = forward;
    ListNode backward = head;
    while (remain.next != null) {
      backward = backward.next;
      remain = remain.next;
    }
    int temp = forward.val;
    forward.val = backward.val;
    backward.val = temp;
    return head;
  }
}
