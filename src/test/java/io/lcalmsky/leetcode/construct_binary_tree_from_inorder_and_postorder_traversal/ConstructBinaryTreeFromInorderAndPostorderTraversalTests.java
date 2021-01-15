package io.lcalmsky.leetcode.construct_binary_tree_from_inorder_and_postorder_traversal;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstructBinaryTreeFromInorderAndPostorderTraversalTests {
    @Test
    public void givenInorderAndPostorder_whenBuildTree_theCorrect() {
        assertAll(
                () -> test(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}, TreeNode.of(3, 9, 20, null, null, 15, 7))
        );
    }

    private void test(int[] inorder, int[] postorder, TreeNode expected) {
        // when
        Solution constructBinaryTreeFromInorderAndPostorderTraversal = new Solution();
        TreeNode actual = constructBinaryTreeFromInorderAndPostorderTraversal.buildTree(inorder, postorder);

        // then
        assertEquals(expected, actual);
    }
}
