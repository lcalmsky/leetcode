package io.lcalmsky.leetcode.minimum_distance_between_bst_nodes;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenTreeNodes_whenFindMinDifference_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(4, 2, 6, 1, 3), 1),
                () -> test(TreeNode.of(1, 0, 48, null, null, 12, 49), 1)
        );
    }

    private void test(TreeNode given, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.minDiffInBST(given);

        // then
        assertEquals(expected, actual);
    }
}
