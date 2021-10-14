package io.lcalmsky.leetcode.construct_binary_search_tree_from_preorder_traversal;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenPreorder_whenConstructBinarySearchTree_thenCorrect() {
        assertAll(
                () -> test(new int[]{8, 5, 1, 7, 10, 12}, TreeNode.of(8, 5, 10, 1, 7, null, 12)),
                () -> test(new int[]{1, 3}, TreeNode.of(1, null, 3))
        );
    }

    private void test(int[] given, TreeNode expected) {
        // when
        Solution solution = new Solution();
        TreeNode actual = solution.bstFromPreorder(given);
        // then
        assertEquals(expected, actual);
    }
}