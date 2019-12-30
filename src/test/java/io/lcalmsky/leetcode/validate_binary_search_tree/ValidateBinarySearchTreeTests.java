package io.lcalmsky.leetcode.validate_binary_search_tree;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidateBinarySearchTreeTests {
    @Test
    public void givenTreeNode_whenValidate_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(2, 1, 3), true),
                () -> test(TreeNode.of(5, 1, 4, null, null, 3, 6), false),
                () -> test(TreeNode.of(10, 5, 15, null, null, 6, 20), false)
        );
    }

    //   10
    // 5   15
    //    6  20

    private void test(TreeNode given, boolean expected) {
        // when
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        boolean actual = validateBinarySearchTree.isValidBST(given);

        // then
        assertEquals(expected, actual);
    }
}
