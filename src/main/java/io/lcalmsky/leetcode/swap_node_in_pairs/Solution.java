package io.lcalmsky.leetcode.swap_node_in_pairs;

import io.lcalmsky.leetcode.ListNode;

public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode current = result;
        while (current.next != null && current.next.next != null) {
            ListNode temp = current.next;
            current.next = current.next.next;
            temp.next = current.next.next;
            current.next.next = temp;
            current = current.next.next;
        }
        return result.next;
    }
}
