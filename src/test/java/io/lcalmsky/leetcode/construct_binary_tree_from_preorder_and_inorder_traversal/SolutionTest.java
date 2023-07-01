package io.lcalmsky.leetcode.construct_binary_tree_from_preorder_and_inorder_traversal;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}, TreeNode.of(3, 9, 20, null, null, 15, 7)),
                () -> test(new int[]{-1}, new int[]{-1}, TreeNode.of(-1))
        );
    }

    private void test(int[] preorder, int[] inorder, TreeNode expected) {
        // when
        Solution solution = new Solution();
        TreeNode actual = solution.buildTree(preorder, inorder);
        // then
        assertEquals(expected, actual);
    }
}