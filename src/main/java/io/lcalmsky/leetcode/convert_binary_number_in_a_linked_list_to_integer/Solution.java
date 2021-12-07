package io.lcalmsky.leetcode.convert_binary_number_in_a_linked_list_to_integer;

import io.lcalmsky.leetcode.ListNode;

public class Solution {

  public int getDecimalValue(ListNode head) {
    StringBuilder stringBuilder = new StringBuilder();
    while (head != null) {
      stringBuilder.append(head.val);
      head = head.next;
    }
    return Integer.valueOf(stringBuilder.toString(), 2);
  }
}

class AnotherSolution {

  public int getDecimalValue(ListNode head) {
    int result = 0;
    while (head != null) {
      result = result * 2 + head.val;
      head = head.next;
    }
    return result;
  }
}
