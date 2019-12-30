package io.lcalmsky.leetcode.remove_duplicates_from_sorted_list;

import io.lcalmsky.leetcode.ListNode;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = head;
        ListNode p = head.next;

        while (p != null) {
            if (p.val == prev.val) prev.next = p.next;
            else prev = p;
            p = p.next;
        }

        return head;
    }
}