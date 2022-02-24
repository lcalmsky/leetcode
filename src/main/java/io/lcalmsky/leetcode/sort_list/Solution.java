package io.lcalmsky.leetcode.sort_list;

import io.lcalmsky.leetcode.ListNode;

public class Solution {

  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode mid = getMid(head);
    ListNode left = sortList(head);
    ListNode right = sortList(mid);
    return merge(left, right);
  }

  ListNode getMid(ListNode head) {
    ListNode midPrev = null;
    while (head != null && head.next != null) {
      midPrev = midPrev == null ? head : midPrev.next;
      head = head.next.next;
    }
    ListNode mid = midPrev.next;
    midPrev.next = null;
    return mid;
  }

  ListNode merge(ListNode left, ListNode right) {
    ListNode dummyHead = new ListNode(0);
    ListNode tail = dummyHead;
    while (left != null && right != null) {
      if (left.val < right.val) {
        tail.next = left;
        left = left.next;
      } else {
        tail.next = right;
        right = right.next;
      }
      tail = tail.next;
    }
    tail.next = (left != null) ? left : right;
    return dummyHead.next;
  }
}