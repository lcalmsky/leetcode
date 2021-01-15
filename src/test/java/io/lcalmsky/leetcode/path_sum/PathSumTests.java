package io.lcalmsky.leetcode.path_sum;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PathSumTests {
    @Test
    public void givenTreeNode_whenSumNodeValues_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(5, 4, 8, 11, null, 13, 4, 7, 2, null, 1), 22, true),
                () -> test(null, 0, false)
        );
    }

    private void test(TreeNode given, int sum, boolean expected) {
        // when
        Solution pathSum = new Solution();
        boolean actual = pathSum.hasPathSum(given, sum);

        // then
        assertEquals(expected, actual);
    }
}
