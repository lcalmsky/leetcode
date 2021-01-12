package io.lcalmsky.leetcode.remove_linked_list_elements;

import io.lcalmsky.leetcode.ListNode;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode p = root;

        while (p.next != null) {
            if (p.next.val == val) p.next = p.next.next;
            else p = p.next;
        }

        return root.next;
    }
}
