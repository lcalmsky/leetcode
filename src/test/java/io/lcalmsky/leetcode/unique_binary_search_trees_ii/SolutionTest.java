package io.lcalmsky.leetcode.unique_binary_search_trees_ii;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenInteger_whenGenerateUniqueBst_thenCorrect() {
        assertAll(
                () -> test(3, Arrays.asList(
                        TreeNode.of(1, null, 2, null, 3),
                        TreeNode.of(1, null, 3, 2),
                        TreeNode.of(2, 1, 3),
                        TreeNode.of(3, 1, null, null, 2),
                        TreeNode.of(3, 2, null, 1))),
                () -> test(1, Collections.singletonList(TreeNode.of(1)))
        );
    }

    private void test(int given, List<TreeNode> expected) {
        // when
        Solution solution = new Solution();
        List<TreeNode> actual = solution.generateTrees(given);

        // then
        assertEquals(expected, actual);
    }
}