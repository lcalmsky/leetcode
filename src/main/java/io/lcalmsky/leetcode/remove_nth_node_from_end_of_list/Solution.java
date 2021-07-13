package io.lcalmsky.leetcode.remove_nth_node_from_end_of_list;

import io.lcalmsky.leetcode.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head, previous = head;
        while (n-- > 0) {
            current = current.next;
        }
        if (current == null) {
            return head.next;
        }
        while (current.next != null) {
            current = current.next;
            previous = previous.next;
        }
        previous.next = previous.next.next;
        return head;
    }
}
