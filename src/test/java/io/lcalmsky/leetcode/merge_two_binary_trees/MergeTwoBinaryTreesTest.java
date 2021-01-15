package io.lcalmsky.leetcode.merge_two_binary_trees;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeTwoBinaryTreesTest {
    @Test
    public void givenTwoBinaryTree_whenMergeThem_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(1, 3, 2, 5), TreeNode.of(2, 1, 3, null, 4, 7), TreeNode.of(3, 4, 5, 5, 4, 7))
        );
    }

    private void test(TreeNode t1, TreeNode t2, TreeNode expected) {
        // when
        Solution mergeTwoBinaryTrees = new Solution();
        TreeNode actual = mergeTwoBinaryTrees.mergeTrees(t1, t2);

        // then
        assertEquals(expected, actual);
    }

}
