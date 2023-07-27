package io.lcalmsky.leetcode.delete_the_middle_node_of_a_linked_list;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testAll() {
        assertAll(
                () -> test(ListNode.of(1, 3, 4, 7, 1, 2, 6), ListNode.of(1, 3, 4, 1, 2, 6)),
                () -> test(ListNode.of(1, 2, 3, 4), ListNode.of(1, 2, 4)),
                () -> test(ListNode.of(2, 1), ListNode.of(2))
        );
    }

    private void test(ListNode head, ListNode expected) {
        // when
        Solution solution = new Solution();
        ListNode actual = solution.deleteMiddle(head);
        // then
        assertEquals(expected, actual);
    }

}