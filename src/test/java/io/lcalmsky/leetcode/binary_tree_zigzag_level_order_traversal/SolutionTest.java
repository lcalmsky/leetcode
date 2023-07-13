package io.lcalmsky.leetcode.binary_tree_zigzag_level_order_traversal;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(TreeNode.of(3, 9, 20, null, null, 15, 7), List.of(List.of(3), List.of(20, 9), List.of(15, 7))),
                () -> test(TreeNode.of(1), List.of(List.of(1)))
        );
    }

    private void test(TreeNode root, List<List<Integer>> expected) {
        // when
        Solution solution = new Solution();
        List<List<Integer>> actual = solution.zigzagLevelOrder(root);
        // then
        assertEquals(expected, actual);
    }
}