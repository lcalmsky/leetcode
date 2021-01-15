package io.lcalmsky.leetcode.binary_tree_preorder_traversal;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreePreorderTraversalTests {
    @Test
    public void givenTreeNode_whenPreorderTraverse_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(1, null, 2, 3), Arrays.asList(1, 2, 3))
        );
    }

    private void test(TreeNode given, List<Integer> expected) {
        // when
        Solution binaryTreePreorderTraversal = new Solution();
        List<Integer> actual = binaryTreePreorderTraversal.preorderTraversal(given);

        // then
        assertEquals(expected, actual);
    }
}
