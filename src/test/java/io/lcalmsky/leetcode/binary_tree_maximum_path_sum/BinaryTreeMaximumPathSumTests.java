package io.lcalmsky.leetcode.binary_tree_maximum_path_sum;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeMaximumPathSumTests {
    @Test
    public void givenTreeNode_whenGetMaximumPathSum_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(1, 2, 3), 6),
                () -> test(TreeNode.of(-10, 9, 20, null, null, 15, 7), 42)
        );
    }

    private void test(TreeNode given, int expected) {
        // when
        BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
        int actual = binaryTreeMaximumPathSum.maxPathSum(given);

        // then
        assertEquals(expected, actual);
    }

}