package io.lcalmsky.leetcode.add_two_numbers;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2, head = null, prev = null, curr = null;
        short c = 0;
        while (p1 != null || p2 != null) {
            c += p1 != null ? p1.val : 0;
            c += p2 != null ? p2.val : 0;
            curr = new ListNode(c % 10);
            c /= 10;
            if (head == null) head = curr;
            if (prev != null) prev.next = curr;
            prev = curr;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

