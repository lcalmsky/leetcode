package io.lcalmsky.leetcode.kth_smallest_element_in_a_bst;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(TreeNode.of(3, 1, 4, null, 2), 1, 1),
                () -> test(TreeNode.of(5, 3, 6, 2, 4, null, null, 1), 3, 3)
        );
    }

    private void test(TreeNode root, int k, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.kthSmallest(root, k);
        // then
        assertEquals(expected, actual);
    }
}