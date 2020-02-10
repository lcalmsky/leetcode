package io.lcalmsky.leetcode.palindrome_linked_list;

import io.lcalmsky.leetcode.ListNode;

public class PalindromeLinkedList {
    private ListNode left;
//    public boolean isPalindrome(ListNode head) {
//        List<Integer> list = new ArrayList<>();
//        while (head != null) {
//            list.add(head.val);
//            head = head.next;
//        }
//        int left = 0, right = list.size() - 1;
//        while (left < right) {
//            if (!list.get(left++).equals(list.get(right--))) return false;
//        }
//
//        return true;
//    }

    public boolean isPalindrome(ListNode head) {
        left = head;
        return helper(head);
    }

    private boolean helper(ListNode right) {
        if (right == null) return true;
        boolean x = helper(right.next);
        if (!x) return false;
        boolean y = left.val == right.val;
        left = left.next;
        return y;
    }
}