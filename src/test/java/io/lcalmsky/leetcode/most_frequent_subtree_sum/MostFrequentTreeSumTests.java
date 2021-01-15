package io.lcalmsky.leetcode.most_frequent_subtree_sum;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MostFrequentTreeSumTests {
    @Test
    public void givenTreeNode_whenFindFrequentSubtreeSum_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(5, 2, -3), new int[]{2, -3, 4}),
                () -> test(TreeNode.of(5, 2, -5), new int[]{2})
        );
    }

    private void test(TreeNode given, int[] expected) {
        // when
        Solution mostFrequentTreeSum = new Solution();
        int[] actual = mostFrequentTreeSum.findFrequentTreeSum(given);

        // then
        assertArrayEquals(expected, actual);
    }
}
