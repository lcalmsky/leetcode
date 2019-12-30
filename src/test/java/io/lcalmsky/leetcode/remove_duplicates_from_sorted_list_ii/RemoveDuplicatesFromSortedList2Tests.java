package io.lcalmsky.leetcode.remove_duplicates_from_sorted_list_ii;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicatesFromSortedList2Tests {
    @Test
    public void givenSortedListNode_whenRemoveDuplicates_thenCorrect() {
        ListNode givenNode1 = new ListNode(1);
        givenNode1.next = new ListNode(2);
        givenNode1.next.next = new ListNode(3);
        givenNode1.next.next.next = new ListNode(3);
        givenNode1.next.next.next.next = new ListNode(4);
        givenNode1.next.next.next.next.next = new ListNode(4);
        givenNode1.next.next.next.next.next.next = new ListNode(5);

        ListNode expectedNode1 = new ListNode(1);
        expectedNode1.next = new ListNode(2);
        expectedNode1.next.next = new ListNode(5);

        ListNode givenNode2 = new ListNode(1);
        givenNode2.next = new ListNode(1);
        givenNode2.next.next = new ListNode(1);
        givenNode2.next.next.next = new ListNode(2);
        givenNode2.next.next.next.next = new ListNode(3);

        ListNode expectedNode2 = new ListNode(2);
        expectedNode2.next = new ListNode(3);

        assertAll(
                () -> test(givenNode1, expectedNode1),
                () -> test(givenNode2, expectedNode2)
        );
    }

    private void test(ListNode given, ListNode expected) {
        // when
        RemoveDuplicatesFromSortedList2 removeDuplicatesFromSortedList2 = new RemoveDuplicatesFromSortedList2();
        ListNode actual = removeDuplicatesFromSortedList2.deleteDuplicates(given);

        // then
        assertEquals(expected, actual);
    }
}
