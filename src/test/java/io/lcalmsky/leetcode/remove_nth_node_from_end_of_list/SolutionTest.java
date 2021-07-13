package io.lcalmsky.leetcode.remove_nth_node_from_end_of_list;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution;

    @Test
    void testAll() {
        assertAll(
                () -> test(ListNode.of(1, 2, 3, 4, 5), 2, ListNode.of(1, 2, 3, 5)),
                () -> test(ListNode.of(1), 1, null),
                () -> test(ListNode.of(1, 2), 1, ListNode.of(1)),
                () -> test(ListNode.of(1, 2), 2, ListNode.of(2)),
                () -> test(ListNode.of(1, 2, 3), 1, ListNode.of(1, 2))
        );
    }

    private void test(ListNode head, int n, ListNode expected) {
        // when
        solution = new Solution();
        ListNode actual = solution.removeNthFromEnd(head, n);

        // then
        assertEquals(expected, actual);
    }

}