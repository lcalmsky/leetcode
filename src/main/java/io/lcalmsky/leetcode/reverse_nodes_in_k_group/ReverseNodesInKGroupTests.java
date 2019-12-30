package io.lcalmsky.leetcode.reverse_nodes_in_k_group;

import io.lcalmsky.leetcode.ListNode;

public class ReverseNodesInKGroupTests {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        ReverseNodesInKGroupTests reverseNodesInKGroupTests = new ReverseNodesInKGroupTests();
        System.out.println(reverseNodesInKGroupTests.reverseKGroup(listNode, 2));
        System.out.println(reverseNodesInKGroupTests.reverseKGroup(listNode, 3));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode result = new ListNode(0);
        result.next = head;
        ListNode prev = result;
        ListNode p = head;
        int i = 0;
        while (p != null) {
            i++;
            if (i % k == 0) {
                prev = reverse(prev, p.next);
                p = prev.next;
            } else p = p.next;
        }
        return result.next;
    }

    private ListNode reverse(ListNode prev, ListNode next) {
        ListNode last = prev.next;
        ListNode curr = last.next;
        while (curr != next) {
            last.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = last.next;
        }
        return last;
    }
}