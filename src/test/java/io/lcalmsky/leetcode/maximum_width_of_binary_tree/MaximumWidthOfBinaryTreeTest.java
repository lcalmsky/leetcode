package io.lcalmsky.leetcode.maximum_width_of_binary_tree;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumWidthOfBinaryTreeTest {
    @Test
    public void givenBinaryTree_whenFindMaximumWidth_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(1, 3, 2, 5, 3, null, 9), 4),
                () -> test(TreeNode.of(1, 3, null, 5, 3), 2),
                () -> test(TreeNode.of(1, 3, 2, 5), 2)
        );
    }

    private void test(TreeNode given, int expected) {
        // when
        Solution maximumWidthOfBinaryTree = new Solution();
        int actual = maximumWidthOfBinaryTree.widthOfBinaryTree(given);

        // then
        assertEquals(expected, actual);
    }
}
