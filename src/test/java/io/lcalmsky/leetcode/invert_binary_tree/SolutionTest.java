package io.lcalmsky.leetcode.invert_binary_tree;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void givenTreeNode_whenInvert_thenCorrect() {
        assertAll(
            () -> test(TreeNode.of(4, 2, 7, 1, 3, 6, 9), TreeNode.of(4, 7, 2, 9, 6, 3, 1))
        );
    }

    private void test(TreeNode given, TreeNode expected) {
        // when
        Solution invertBinaryTree = new Solution();
        TreeNode actual = invertBinaryTree.invertTree(given);

        // then
        assertEquals(expected, actual);
    }
}