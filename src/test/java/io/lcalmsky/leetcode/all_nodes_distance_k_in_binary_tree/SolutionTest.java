package io.lcalmsky.leetcode.all_nodes_distance_k_in_binary_tree;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenBinaryTree_whenReturnValuesOfAllNodesThatHaveADistanceKFromTargetNode_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4), TreeNode.of(5, 6, 2, null, null, 7, 4), 2, Arrays.asList(7, 4, 1))
        );
    }

    private void test(TreeNode root, TreeNode target, int K, List<Integer> expected) {
        // when
        Solution solution = new Solution();
        List<Integer> actual = solution.distanceK(root, target, K);

        // then
        assertEquals(expected, actual);
    }
}
