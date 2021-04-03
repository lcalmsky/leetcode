package io.lcalmsky.leetcode.smallest_subtree_with_all_the_deepest_nodes;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenTreeNode_whenFindSmallestSubtreeWithDeepestNodes_then() {
        assertAll(
                () -> test(TreeNode.of(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4), TreeNode.of(2, 7, 4))
        );
    }

    private void test(TreeNode given, TreeNode expected) {
        // when
        Solution solution = new Solution();
        TreeNode actual = solution.subtreeWithAllDeepest(given);

        // then
        assertEquals(expected, actual);
    }
}
