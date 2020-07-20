package io.lcalmsky.leetcode.minimum_absolute_different_in_a_bst;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumAbsoluteDifferentInABstTests {
    @Test
    public void givenTreeNode_whenFindMinimumAbsoluteDifferent_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(1, 3, 2), 1)
        );
    }

    private void test(TreeNode given, int expected) {
        // when
        MinimumAbsoluteDifferentInABst minimumAbsoluteDifferentInABst = new MinimumAbsoluteDifferentInABst();
        int actual = minimumAbsoluteDifferentInABst.getMinimumDifference(given);

        // then
        assertEquals(expected, actual);
    }
}
