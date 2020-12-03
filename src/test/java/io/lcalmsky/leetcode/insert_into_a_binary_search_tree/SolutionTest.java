package io.lcalmsky.leetcode.insert_into_a_binary_search_tree;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenBinarySearchTree_whenInsertTreeNode_thenCorrect() {
        assertAll(
                () -> test(null, 5, TreeNode.of(5)),
                () -> test(TreeNode.of(4, 2, 7, 1, 3), 5, TreeNode.of(4, 2, 7, 1, 3, 5)),
                () -> test(TreeNode.of(40, 20, 60, 10, 30, 50, 70), 25, TreeNode.of(40, 20, 60, 10, 30, 50, 70, null, null, 25)),
                () -> test(TreeNode.of(4, 2, 7, 1, 3, null, null, null, null, null, null), 5, TreeNode.of(4, 2, 7, 1, 3, 5))
        );
    }

    private void test(TreeNode root, int k, TreeNode expected) {
        // when
        Solution solution = new Solution();
        TreeNode actual = solution.insertIntoBST(root, k);

        // then
        assertEquals(expected, actual);
    }
}
