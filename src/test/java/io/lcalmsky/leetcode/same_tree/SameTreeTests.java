package io.lcalmsky.leetcode.same_tree;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SameTreeTests {
    @Test
    public void givenTwoTreeNodes_whenCheckBothAreSame_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(1, 2, 3), TreeNode.of(1, 2, 3), true),
                () -> test(TreeNode.of(1, 2), TreeNode.of(1, null, 2), false),
                () -> test(TreeNode.of(1, 2, 1), TreeNode.of(1, 1, 2), false)
        );
    }

    private void test(TreeNode p, TreeNode q, boolean expected) {
        // when
        SameTree sameTree = new SameTree();
        boolean actual = sameTree.isSameTree(p, q);

        // then
        assertEquals(expected, actual);
    }
}