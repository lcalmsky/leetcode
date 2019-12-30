package io.lcalmsky.leetcode.binary_tree_inorder_traversal.binary_tree_inorder_traversal;

import io.lcalmsky.leetcode.TreeNode;
import io.lcalmsky.leetcode.binary_tree_inorder_traversal.BinaryTreeInorderTraversal;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeInorderTraversalTests {
    @Test
    public void givenTree_whenInorderTravel_thenCorrect() {
        TreeNode given = new TreeNode(1);
        given.left = null;
        given.right = new TreeNode(2);
        given.right.left = new TreeNode(3);

        assertAll(
                () -> test(given, Arrays.asList(1, 3, 2))
        );
    }

    private void test(TreeNode given, List<Integer> expected) {
        // when
        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        List<Integer> actual = binaryTreeInorderTraversal.inorderTraversal(given);

        // then
        assertEquals(expected, actual);
    }
}