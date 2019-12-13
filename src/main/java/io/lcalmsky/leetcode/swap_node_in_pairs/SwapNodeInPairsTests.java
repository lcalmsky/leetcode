package io.lcalmsky.leetcode.swap_node_in_pairs;

import java.util.StringJoiner;

public class SwapNodeInPairsTests {
    public static void main(String[] args) {
        SwapNodeInPairsTests swapNodeInPairsTests = new SwapNodeInPairsTests();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        System.out.println(swapNodeInPairsTests.swapPairs(l1));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode result = new ListNode(0);
        result.next = head;
        ListNode p = result;

        ListNode tmp1;
        ListNode tmp2;
        while (p.next != null && p.next.next != null) {
            tmp1 = p;
            p = p.next;
            tmp1.next = p.next;

            tmp2 = p.next.next;
            p.next.next = p;
            p.next = tmp2;
        }

        return result.next;
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