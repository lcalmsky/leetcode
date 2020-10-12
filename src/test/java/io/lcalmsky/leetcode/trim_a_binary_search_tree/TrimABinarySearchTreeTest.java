package io.lcalmsky.leetcode.trim_a_binary_search_tree;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TrimABinarySearchTreeTest {
    @Test
    public void givenBinarySearchTree_whenTrimTreeThatItsElementsLiesBetweenLowAndHigh_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(1, 0, 2), 1, 2, TreeNode.of(1, null, 2)),
                () -> test(TreeNode.of(3, 0, 4, null, 2, null, null, 1), 1, 3, TreeNode.of(3, 2, null, 1)),
                () -> test(TreeNode.of(1), 1, 2, TreeNode.of(1)),
                () -> test(TreeNode.of(1, null, 2), 1, 3, TreeNode.of(1, null, 2)),
                () -> test(TreeNode.of(1, null, 2), 2, 4, TreeNode.of(2))
        );
    }

    private void test(TreeNode root, int low, int high, TreeNode expected) {
        // when
        TrimABinarySearchTree trimABinarySearchTree = new TrimABinarySearchTree();
        TreeNode actual = trimABinarySearchTree.trimBST(root, low, high);

        // then
        assertEquals(expected, actual);
    }

}
