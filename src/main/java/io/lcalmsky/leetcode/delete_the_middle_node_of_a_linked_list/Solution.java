package io.lcalmsky.leetcode.delete_the_middle_node_of_a_linked_list;

import io.lcalmsky.leetcode.ListNode;

public class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev == slow) {
            return null;
        }
        if (slow != null) {
            prev.next = slow.next;
        }
        return head;
    }
}
