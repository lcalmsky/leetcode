package io.lcalmsky.leetcode.diameter_of_binary_tree;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenTreeNode_whenFindDiameterOfBinaryTree_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(1, 2, 3, 4, 5), 3),
                () -> test(TreeNode.of(1, 2), 1)
        );
    }

    private void test(TreeNode given, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.diameterOfBinaryTree(given);

        // then
        assertEquals(expected, actual);
    }
}