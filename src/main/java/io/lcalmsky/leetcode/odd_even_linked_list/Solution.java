package io.lcalmsky.leetcode.odd_even_linked_list;

import io.lcalmsky.leetcode.ListNode;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode l1 = head, l2 = head.next, t;

        while (l2 != null && l2.next != null) {
            t = new ListNode(l2.next.val);
            t.next = l1.next;
            l1.next = t;
            l2.next = l2.next.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        return head;
    }
}
