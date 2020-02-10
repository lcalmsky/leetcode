package io.lcalmsky.leetcode.palindrome_linked_list;

import io.lcalmsky.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int left = 0, right = list.size() - 1;
        while (left < right) {
            if (!list.get(left++).equals(list.get(right--))) return false;
        }

        return true;
    }
}
