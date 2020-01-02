package io.lcalmsky.leetcode.minimum_depth_of_binary_tree;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumDepthOfBinaryTreeTests {
    @Test
    public void givenBinaryTree_whenGetMinimumDepth_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(3, 9, 20, null, null, 15, 7), 2),
                () -> test(TreeNode.of(1, 2), 2)
        );
    }

    private void test(TreeNode given, int expected) {
        // when
        MinimumDepthOfBinaryTree minimumDepthOfBinaryTree = new MinimumDepthOfBinaryTree();
        int actual = minimumDepthOfBinaryTree.minDepth(given);

        // then
        assertEquals(expected, actual);
    }
}
