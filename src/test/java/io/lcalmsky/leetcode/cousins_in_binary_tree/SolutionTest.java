package io.lcalmsky.leetcode.cousins_in_binary_tree;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void givenBinaryTreeAndTwoIntegers_whenFindThemCousins_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(1, 2, 3, 4), 4, 3, false),
                () -> test(TreeNode.of(1, 2, 3, null, 4, null, 5), 5, 4, true),
                () -> test(TreeNode.of(1, 2, 3, null, 4), 2, 3, false)
        );
    }

    private void test(TreeNode node, int x, int y, boolean expected) {
        // when
        Solution solution = new Solution();
        boolean actual = solution.isCousins(node, x, y);
        // then
        assertEquals(expected, actual);
    }
}