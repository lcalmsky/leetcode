package io.lcalmsky.leetcode.flatten_binary_tree_to_linked_list;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
    @Test
    public void testAll() {
        assertAll(
                () -> test(
                        TreeNode.of(1, 2, 5, 3, 4, null, 6),
                        TreeNode.of(1, null, 2, null, 3, null, 4, null, 5, null, 6)
                )
        );
    }

    private void test(TreeNode given, TreeNode expected) {
        // when
        Solution solution = new Solution();
        solution.flatten(given);

        // then
        assertEquals(expected, given);
    }
}
