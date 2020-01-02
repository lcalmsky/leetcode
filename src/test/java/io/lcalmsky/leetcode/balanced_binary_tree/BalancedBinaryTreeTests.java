package io.lcalmsky.leetcode.balanced_binary_tree;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BalancedBinaryTreeTests {

    @Test
    public void givenBinaryTree_whenCheckWhetherIsBalanced_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(3, 9, 20, null, null, 15, 7), true),
                () -> test(TreeNode.of(1, 2, 2, 3, 3, null, null, 4, 4), false),
                () -> test(TreeNode.of(1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, null, null, 5, 5), true)
        );
    }

    //         1
    //   2          2
    // 3    3    4    4
    //4 4 4 4        5 5
    private void test(TreeNode given, boolean expected) {
        // when
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        boolean actual = balancedBinaryTree.isBalanced(given);

        // then
        assertEquals(expected, actual);
    }


}
