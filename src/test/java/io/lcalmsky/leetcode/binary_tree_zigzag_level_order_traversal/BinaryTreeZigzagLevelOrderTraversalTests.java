package io.lcalmsky.leetcode.binary_tree_zigzag_level_order_traversal;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BinaryTreeZigzagLevelOrderTraversalTests {
    @Test
    public void givenBinaryTree_whenTravelingInZigZagOrder_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(3, 9, 20, null, null, 15, 7), Arrays.asList(
                        Collections.singletonList(3),
                        Arrays.asList(20, 9),
                        Arrays.asList(15, 7)
                )),
                () -> test(TreeNode.of(1, 2, 3, 4, null, null, 5), Arrays.asList(
                        Collections.singletonList(1),
                        Arrays.asList(3, 2),
                        Arrays.asList(4, 5)
                ))
        );
    }

    private void test(TreeNode given, List<List<Integer>> expected) {
        // when
        Solution binaryTreeZigzagLevelOrderTraversal = new Solution();
        List<List<Integer>> actual = binaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder(given);

        // then
        assertThat(actual).containsOnlyElementsOf(expected);
    }
}
