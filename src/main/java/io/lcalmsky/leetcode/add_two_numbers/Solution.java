package io.lcalmsky.leetcode.add_two_numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        while (l1.next != null) {
            list1.add(l1.val);
            l1 = l1.next;
        }
        List<Integer> list2 = new ArrayList<>();
        while (l2.next != null) {
            list2.add(l2.val);
            l2 = l2.next;
        }

        Collections.reverse(list1);
        Collections.reverse(list2);

        int i1 = Integer.parseInt(list1.stream().map(String::valueOf).collect(Collectors.joining()));
        int i2 = Integer.parseInt(list2.stream().map(String::valueOf).collect(Collectors.joining()));

        int sum = i1 + i2;

        ListNode result = null;
        ListNode tmp1 = null;
        ListNode tmp2 = null;

        while (sum > 10) {
            tmp1 = new ListNode(sum % 10);
            if (tmp2 != null) tmp2.next = tmp1;
            else tmp2 = tmp1;
            sum /= 10;
        }


        return tmp2;
    }

    public static void main(String[] args) {


        ListNode l1 = null; // 243
        ListNode l2 = null; // 564
        l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(new Solution().addTwoNumbers(l1, l2));
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

