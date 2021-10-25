package io.lcalmsky.leetcode.count_complete_tree_nodes;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenCompleteTree_whenCount_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(1, 2, 3, 4, 5, 6), 6)
        );
    }

    private void test(TreeNode given, int expected) {
        // when
        Solution countCompleteTreeNodes = new Solution();
        int actual = countCompleteTreeNodes.countNodes(given);
        // then
        assertEquals(expected, actual);
    }
}