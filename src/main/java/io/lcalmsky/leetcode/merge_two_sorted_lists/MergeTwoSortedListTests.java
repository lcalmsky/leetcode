package io.lcalmsky.leetcode.merge_two_sorted_lists;

import io.lcalmsky.leetcode.ListNode;

public class MergeTwoSortedListTests {
    public static void main(String[] args) {
        MergeTwoSortedListTests mergeTwoSortedListTests = new MergeTwoSortedListTests();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println(mergeTwoSortedListTests.mergeTwoLists(l1, l2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null) head.next = l1;
        else head.next = l2;

        return result.next;
    }
}