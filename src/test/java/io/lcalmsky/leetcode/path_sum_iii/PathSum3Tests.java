package io.lcalmsky.leetcode.path_sum_iii;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PathSum3Tests {
    @Test
    public void givenTreeNode_whenSum_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1), 8, 3)
        );
    }

    private void test(TreeNode given, int sum, int expected) {
        // when
        PathSum3 pathSum3 = new PathSum3();
        int actual = pathSum3.pathSum(given, sum);

        // then
        assertEquals(expected, actual);
    }

}
