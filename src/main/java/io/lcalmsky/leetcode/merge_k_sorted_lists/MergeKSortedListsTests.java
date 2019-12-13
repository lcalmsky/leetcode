package io.lcalmsky.leetcode.merge_k_sorted_lists;

import java.util.PriorityQueue;
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
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((l1, l2) -> l1.val - l2.val);

        ListNode head = new ListNode(0);
        ListNode p = head;

        for (ListNode list : lists) {
            if (list != null)
                queue.offer(list);
        }

        while (!queue.isEmpty()) {
            ListNode n = queue.poll();
            p.next = n;
            p = p.next;

            if (n.next != null)
                queue.offer(n.next);
        }

        return head.next;

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