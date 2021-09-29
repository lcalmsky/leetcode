package io.lcalmsky.leetcode.split_linked_list_in_parts;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    @Test
    void givenListNode_whenSplitInParts_thenCorrect() {
        assertAll(
                () -> test(ListNode.of(1, 2, 3), 5, new ListNode[]{
                        ListNode.of(1),
                        ListNode.of(2),
                        ListNode.of(3),
                        null,
                        null
                }),
                () -> test(ListNode.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3, new ListNode[]{
                        ListNode.of(1, 2, 3, 4),
                        ListNode.of(5, 6, 7),
                        ListNode.of(8, 9, 10)
                })
        );
    }

    private void test(ListNode head, int k, ListNode[] expected) {
        // when
        Solution solution = new Solution();
        ListNode[] actual = solution.splitListToParts(head, k);

        // then
        assertArrayEquals(expected, actual);
    }
}