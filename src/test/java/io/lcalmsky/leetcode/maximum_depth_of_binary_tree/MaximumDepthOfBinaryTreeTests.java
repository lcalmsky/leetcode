package io.lcalmsky.leetcode.maximum_depth_of_binary_tree;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumDepthOfBinaryTreeTests {
    @Test
    public void givenBinaryTree_whenCalculateDepth_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(3, 9, 20, null, null, 15, 7), 3)
        );
    }

    public void test(TreeNode given, int expected) {
        // when
        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
        int actual = maximumDepthOfBinaryTree.maxDepth(given);

        // then
        assertEquals(expected, actual);
    }
}
