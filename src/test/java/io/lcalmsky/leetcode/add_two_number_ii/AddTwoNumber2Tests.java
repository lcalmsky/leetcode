package io.lcalmsky.leetcode.add_two_number_ii;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTwoNumber2Tests {
    @Test
    public void givenTwoSinglyLinkedList_whenAddThem_thenCorrect() {
        assertAll(
                () -> test(ListNode.of(7, 2, 4, 3), ListNode.of(5, 6, 4), ListNode.of(7, 8, 0, 7))
        );
    }

    private void test(ListNode l1, ListNode l2, ListNode expected) {
        // when
        Solution addTwoNumber2 = new Solution();
        ListNode actual = addTwoNumber2.addTwoNumbers(l1, l2);

        // then
        assertEquals(expected, actual);
    }
}
