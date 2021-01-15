package io.lcalmsky.leetcode.binary_tree_postorder_traversal;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreePostorderTraversalTests {
    @Test
    public void givenTreeNode_whenTraverseInPostorder_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(1, null, 2, 3), Arrays.asList(3, 2, 1))
        );
    }

    private void test(TreeNode given, List<Integer> expected) {
        // when
        Solution binaryTreePostorderTraversal = new Solution();
        List<Integer> actual = binaryTreePostorderTraversal.postorderTraversal(given);

        // then
        assertEquals(expected, actual);
    }
}
