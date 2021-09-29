package io.lcalmsky.leetcode.split_linked_list_in_parts;

import io.lcalmsky.leetcode.ListNode;

public class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = getLength(head);
        int each = length / k;
        int extra = length % k;
        ListNode[] listNodes = new ListNode[k];
        ListNode prev = null;
        for (int i = 0; i < k; i++, extra--) {
            listNodes[i] = head;
            for (int j = 0; j < each + (extra > 0 ? 1 : 0); j++) {
                prev = head;
                head = head.next;
            }
            if (prev != null) {
                prev.next = null;
            }
        }
        return listNodes;
    }

    private int getLength(ListNode node) {
        int length = 0;
        ListNode current = node;
        while (current != null) {
            current = current.next;
            length++;
        }
        return length;
    }
}
