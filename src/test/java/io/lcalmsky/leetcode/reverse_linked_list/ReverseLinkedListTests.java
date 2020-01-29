package io.lcalmsky.leetcode.reverse_linked_list;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseLinkedListTests {
    @Test
    public void givenListNode_whenReverse_thenCorrect() {
        assertAll(
                () -> test(ListNode.of(1, 2, 3, 4, 5), ListNode.of(5, 4, 3, 2, 1))
        );
    }

    private void test(ListNode given, ListNode expected) {
        // when
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode actual = reverseLinkedList.reverseList(given);

        // then
        assertEquals(expected, actual);
    }
}