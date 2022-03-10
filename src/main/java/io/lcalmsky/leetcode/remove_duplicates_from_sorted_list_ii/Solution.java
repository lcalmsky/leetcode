package io.lcalmsky.leetcode.remove_duplicates_from_sorted_list_ii;

import io.lcalmsky.leetcode.ListNode;

public class Solution {

  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode current = dummy;
    int duplicated;
    while (current.next != null && current.next.next != null) {
      if (current.next.val == current.next.next.val) {
        duplicated = current.next.val;
        while (current.next != null && current.next.val == duplicated) {
          current.next = current.next.next;
        }
      } else {
        current = current.next;
      }
    }
    return dummy.next;
  }
}
