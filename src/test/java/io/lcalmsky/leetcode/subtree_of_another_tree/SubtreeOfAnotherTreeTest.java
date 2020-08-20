package io.lcalmsky.leetcode.subtree_of_another_tree;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SubtreeOfAnotherTreeTest {
    @Test
    public void givenTwoTreeNodes_whenFindOneIsSubtreeOfAnother_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(3, 4, 5, 1, 2), TreeNode.of(4, 1, 2), true),
                () -> test(TreeNode.of(3, 4, 5, 1, 2, null, null, null, null, 0), TreeNode.of(4, 1, 2), false)
        );
    }

    private void test(TreeNode s, TreeNode t, boolean expected) {
        // when
        SubtreeOfAnotherTree subtreeOfAnotherTree = new SubtreeOfAnotherTree();
        boolean actual = subtreeOfAnotherTree.isSubtree(s, t);

        // then
        assertEquals(expected, actual);
    }
}