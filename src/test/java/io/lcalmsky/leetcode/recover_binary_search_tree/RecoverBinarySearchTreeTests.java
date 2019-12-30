package io.lcalmsky.leetcode.recover_binary_search_tree;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecoverBinarySearchTreeTests {
    @Test
    public void givenSwappedTree_whenRecover_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(1, 3, null, null, 2), TreeNode.of(3, 1, null, null, 2)),
                () -> test(TreeNode.of(3, 1, 4, null, null, 2), TreeNode.of(2, 1, 4, null, null, 3))
        );
    }

    private void test(TreeNode given, TreeNode expected) {
        // when
        RecoverBinarySearchTree recoverBinarySearchTree = new RecoverBinarySearchTree();
        recoverBinarySearchTree.recoverTree(given);

        // then
        assertEquals(expected, given);

        // log
        TreeNode.print(expected);
    }
}