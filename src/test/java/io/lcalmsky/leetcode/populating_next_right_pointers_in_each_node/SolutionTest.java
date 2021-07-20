package io.lcalmsky.leetcode.populating_next_right_pointers_in_each_node;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {
    @Test
    void test() {
        // given
        Node root = new Node(1,
                new Node(2, new Node(4), new Node(5), null),
                new Node(3, new Node(6), new Node(7), null),
                null);
        // when
        Solution solution = new Solution();
        Node actual = solution.connect(root);

        // then
        assertNull(actual.next);
        assertEquals(actual.left.next, actual.right);
        assertEquals(actual.left.left.next, actual.left.right);
        assertEquals(actual.left.right.next, actual.right.left);
        assertEquals(actual.right.left.next, actual.right.right);
        assertNull(actual.right.right.next);
    }
}