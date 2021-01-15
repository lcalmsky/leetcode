package io.lcalmsky.leetcode.construct_binary_tree_from_preorder_and_inorder_traversal;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstructBinaryTreeFromPreorderAndInorderTraversalTests {
    @Test
    public void givenPreorderAndInorderArray_whenConstructBinaryTree_thenCorrect() {
        test(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}, TreeNode.of(3, 9, 20, null, null, 15, 7));
    }

    private void test(int[] preorder, int[] inorder, TreeNode expected) {
        // when
        Solution constructBinaryTreeFromPreorderAndInorderTraversal = new Solution();
        TreeNode actual = constructBinaryTreeFromPreorderAndInorderTraversal.buildTree(preorder, inorder);

        // then
        assertEquals(expected, actual);
    }
}
