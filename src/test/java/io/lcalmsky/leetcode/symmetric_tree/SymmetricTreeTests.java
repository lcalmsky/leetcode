package io.lcalmsky.leetcode.symmetric_tree;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SymmetricTreeTests {
    @Test
    public void givenBinaryTree_whenCheckWhetherIsSymmetric_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(1, 2, 2, 3, 4, 4, 3), true),
                () -> test(TreeNode.of(1, 2, 2, null, 3, null, 3), false),
                () -> test(null, true),
                () -> test(TreeNode.of(1, 2, 2, 2, null, 2), false)
        );
    }

    private void test(TreeNode given, boolean expected) {
        // when
        Solution symmetricTree = new Solution();
        boolean actual = symmetricTree.isSymmetric(given);

        // then
        assertEquals(expected, actual);
    }
}
