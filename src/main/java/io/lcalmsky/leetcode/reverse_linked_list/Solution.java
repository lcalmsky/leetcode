package io.lcalmsky.leetcode.reverse_linked_list;

import io.lcalmsky.leetcode.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        head.next = null;
        ListNode node = reverseList(nextNode);
        nextNode.next = head;
        return node;
    }

    public ListNode reverseListInIterateWay(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = p1.next;
        head.next = null;
        while (p1 != null && p2 != null) {
            ListNode node = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = node;
        }
        return p1;
    }
}
