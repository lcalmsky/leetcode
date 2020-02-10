package io.lcalmsky.leetcode.palindrome_linked_list;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromeLinkedListTests {
    @Test
    public void givenListNode_whenCheckIsPalindrome_thenCorrect() {
        assertAll(
                () -> test(ListNode.of(1, 2), false),
                () -> test(ListNode.of(1, 2, 2, 1), true)
        );
    }

    private void test(ListNode given, boolean expected) {
        // when
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        boolean actual = palindromeLinkedList.isPalindrome(given);

        // then
        assertEquals(expected, actual);
    }
}
