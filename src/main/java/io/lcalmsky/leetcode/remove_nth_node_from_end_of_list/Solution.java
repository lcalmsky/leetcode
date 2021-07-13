package io.lcalmsky.leetcode.remove_nth_node_from_end_of_list;

import io.lcalmsky.leetcode.ListNode;

import java.util.Stack;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> reverseOrderNodes = new Stack<>();
        Stack<ListNode> naturalOrderNodes = new Stack<>();
        while (head != null) {
            reverseOrderNodes.push(head);
            head = head.next;
        }
        ListNode current = null;
        while (n-- > 0) {
            current = reverseOrderNodes.pop();
            naturalOrderNodes.push(current);
        }
        naturalOrderNodes.pop();
        while (!reverseOrderNodes.isEmpty()) {
            naturalOrderNodes.push(reverseOrderNodes.pop());
        }
        if (naturalOrderNodes.isEmpty()) {
            return null;
        }
        head = naturalOrderNodes.pop();
        head.next = null;
        current = head;
        while (!naturalOrderNodes.isEmpty()) {
            current.next = naturalOrderNodes.pop();
            current = current.next;
        }
        current.next = null;
        return head;
    }
}
