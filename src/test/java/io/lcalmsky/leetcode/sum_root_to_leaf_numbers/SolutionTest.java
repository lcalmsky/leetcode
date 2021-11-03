package io.lcalmsky.leetcode.sum_root_to_leaf_numbers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void givenTreeNode_whenSumRootToLeaf_thenCorrect() {
        assertAll(
            () -> test(TreeNode.of(1, 2, 3), 25),
            () -> test(TreeNode.of(4, 9, 0, 5, 1), 1026)
        );
    }

    private void test(TreeNode given, int expected) {
        // when
        Solution sumRootToLeafNumbers = new Solution();
        int actual = sumRootToLeafNumbers.sumNumbers(given);

        // then
        assertEquals(expected, actual);
    }
}