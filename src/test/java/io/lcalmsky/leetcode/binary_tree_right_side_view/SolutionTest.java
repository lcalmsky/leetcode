package io.lcalmsky.leetcode.binary_tree_right_side_view;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(TreeNode.of(1, 2, 3, null, 5, null, 4), List.of(1, 3, 4)),
                () -> test(TreeNode.of(1, null, 3), List.of(1, 3)),
                () -> test(null, List.of())
        );
    }

    private void test(TreeNode root, List<Integer> expected) {
        // when
        Solution solution = new Solution();
        List<Integer> actual = solution.rightSideView(root);
        // then
        assertEquals(expected, actual);
    }
}