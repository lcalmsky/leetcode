package io.lcalmsky.leetcode.remove_duplicates_from_sorted_list_ii;

import io.lcalmsky.leetcode.ListNode;

public class RemoveDuplicatesFromSortedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode p = temp;
        int duplicated;
        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                duplicated = p.next.val;
                while (p.next != null && p.next.val == duplicated) {
                    p.next = p.next.next;
                }
            } else p = p.next;
        }
        return temp.next;
    }
}