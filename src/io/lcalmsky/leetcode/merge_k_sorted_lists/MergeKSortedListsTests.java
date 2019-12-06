package io.lcalmsky.leetcode.merge_k_sorted_lists;

import java.util.StringJoiner;

public class MergeKSortedListsTests {
    public static void main(String[] args) {
        MergeKSortedListsTests mergeKSortedListsTests = new MergeKSortedListsTests();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        System.out.println(mergeKSortedListsTests.mergeKLists(new ListNode[]{l1, l2, l3}));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        ListNode tmp = null;
        int min, minIdx = 0;
        while (anyNonNull(lists)) {
            min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                tmp = lists[i];
                if (tmp != null) {
                    if (tmp.val < min) {
                        min = tmp.val;
                        minIdx = i;
                    }
                }
            }
            head.next = lists[minIdx];
            lists[minIdx] = lists[minIdx].next;
            head = head.next;
        }

        addNonNull(head, lists);

        return result.next;
    }

    private void addNonNull(ListNode head, ListNode[] lists) {
        for (ListNode list : lists) {
            if (list != null) {
                head.next = list;
                return;
            }
        }
    }

    private boolean anyNonNull(ListNode[] lists) {
        for (ListNode list : lists) {
            if (list != null) return true;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ListNode.class.getSimpleName() + "[", "]")
                .add("val=" + val)
                .add("next=" + next)
                .toString();
    }
}