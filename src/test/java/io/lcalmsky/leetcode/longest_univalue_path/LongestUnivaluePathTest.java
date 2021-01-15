package io.lcalmsky.leetcode.longest_univalue_path;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestUnivaluePathTest {
    @Test
    public void givenTreeNode_whenFindLongestUnivaluePath_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(5, 4, 5, 1, 1, 5), 2),
                () -> test(TreeNode.of(1, 4, 5, 4, 4, 5), 2)
        );
    }

    private void test(TreeNode given, int expected) {
        // when
        Solution longestUnivaluePath = new Solution();
        int actual = longestUnivaluePath.longestUnivaluePath(given);

        // then
        assertEquals(expected, actual);
    }

}
