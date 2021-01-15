package io.lcalmsky.leetcode.two_sum_iv_input_is_a_bst;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoSum4InputIsABstTest {
    @Test
    public void givenBinaryTree_whenFindTwoSum_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(5, 3, 6, 2, 4, 7), 9, true),
                () -> test(TreeNode.of(5, 3, 6, 2, 4, 7), 28, false)
        );
    }

    private void test(TreeNode given, int k, boolean expected) {
        // when
        Solution twoSum4InputIsABst = new Solution();
        boolean actual = twoSum4InputIsABst.findTarget(given, k);

        // then
        assertEquals(expected, actual);
    }

}
