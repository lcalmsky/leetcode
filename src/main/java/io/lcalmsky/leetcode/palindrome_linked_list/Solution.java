package io.lcalmsky.leetcode.palindrome_linked_list;

import io.lcalmsky.leetcode.ListNode;

public class Solution {

  private ListNode left;

  public boolean isPalindrome(ListNode head) {
    left = head;
    return helper(head);
  }

  private boolean helper(ListNode right) {
    if (right == null) {
      return true;
    }
    boolean rightResult = helper(right.next);
    if (!rightResult) {
      return false;
    }
    boolean equals = left.val == right.val;
    left = left.next;
    return equals;
  }
}
