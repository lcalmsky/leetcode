package io.lcalmsky.leetcode.maximum_binary_tree;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumBinaryTreeTest {
    @Test
    public void givenNumbers_whenConstructMaximumBinaryTree_thenCorrect() {
        assertAll(
                () -> test(new int[]{3, 2, 1, 6, 0, 5}, TreeNode.of(6, 3, 5, null, 2, 0, null, null, 1))
        );
    }

    private void test(int[] given, TreeNode expected) {
        // when
        MaximumBinaryTree maximumBinaryTree = new MaximumBinaryTree();
        TreeNode actual = maximumBinaryTree.constructMaximumBinaryTree(given);

        // then
        assertEquals(expected, actual);
    }
}