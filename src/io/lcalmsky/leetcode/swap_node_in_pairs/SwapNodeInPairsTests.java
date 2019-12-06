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
        ListNode result = new ListNode(0);
        ListNode p = result;
        ListNode tmp1 = new ListNode(0);
        ListNode tmp2 = new ListNode(0);
        while (head != null) {
            tmp2 = head;
            tmp1 = head.next;
            p = tmp2;
            p.next = tmp1;

            tmp1.next = new ListNode(head.val);
            head = head.next;
            p.next = tmp1;
            p = p.next;
            tmp1 = new ListNode(head.val);
            head = head.next;
            p.next = tmp1;
            p = p.next;
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