package io.lcalmsky.leetcode.remove_duplicates_from_sorted_list;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicatesFromSortedListTests {
    @Test
    public void givenSortedList_whenRemoveDuplicates_thenLeftOne() {
        ListNode givenList = new ListNode(1);
        givenList.next = new ListNode(1);
        givenList.next.next = new ListNode(2);
        ListNode expectedList = new ListNode(1);
        expectedList.next = new ListNode(2);

        ListNode givenList2 = new ListNode(1);
        givenList2.next = new ListNode(1);
        givenList2.next.next = new ListNode(2);
        givenList2.next.next.next = new ListNode(3);
        givenList2.next.next.next.next = new ListNode(3);
        ListNode expectedList2 = new ListNode(1);
        expectedList2.next = new ListNode(2);
        expectedList2.next.next = new ListNode(3);

        ListNode givenList3 = new ListNode(1);
        givenList3.next = new ListNode(1);
        givenList3.next.next = new ListNode(1);
        ListNode expectedList3 = new ListNode(1);

        assertAll(
                () -> test(givenList, expectedList),
                () -> test(givenList2, expectedList2),
                () -> test(givenList3, expectedList3)
        );
    }

    private void test(ListNode given, ListNode expected) {
        // when
        Solution removeDuplicatesFromSortedList = new Solution();
        ListNode actual = removeDuplicatesFromSortedList.deleteDuplicates(given);

        // then
        assertEquals(expected, actual);

        // log
        System.out.println(expected);
        System.out.println(actual);
    }
}
