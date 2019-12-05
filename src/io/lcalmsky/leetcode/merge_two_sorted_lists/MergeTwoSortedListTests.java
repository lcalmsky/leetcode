package io.lcalmsky.leetcode.merge_two_sorted_lists;

public class MergeTwoSortedListTests {
    public static void main(String[] args) {
        MergeTwoSortedListTests mergeTwoSortedListTests = new MergeTwoSortedListTests();
        ListNode l1 = new ListNode(1);
        ListNode l2;
        mergeTwoSortedListTests.mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        return null;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
