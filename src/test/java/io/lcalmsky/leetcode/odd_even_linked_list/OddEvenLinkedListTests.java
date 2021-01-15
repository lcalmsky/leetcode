package io.lcalmsky.leetcode.odd_even_linked_list;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OddEvenLinkedListTests {
    @Test
    public void givenLinkedList_whenSortOddEvenOrder_thenCorrect() {
        assertAll(
                () -> test(ListNode.of(1, 2, 3, 4, 5), ListNode.of(1, 3, 5, 2, 4)),
                () -> test(ListNode.of(2, 1, 3, 5, 6, 4, 7), ListNode.of(2, 3, 6, 7, 1, 5, 4))
        );
    }

    private void test(ListNode given, ListNode expected) {
        // when
        Solution oddEvenLinkedList = new Solution();
        ListNode actual = oddEvenLinkedList.oddEvenList(given);

        // then
        assertEquals(expected, actual);
    }
}
