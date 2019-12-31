package io.lcalmsky.leetcode.binary_tree_level_order_traversal;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BinaryTreeLevelOrderTraversalTests {
    @Test
    public void givenBinaryTree_whenTravelInLevelOrder_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(3, 9, 20, null, null, 15, 7), Arrays.asList(
                        Collections.singletonList(3),
                        Arrays.asList(9, 20),
                        Arrays.asList(15, 7)
                ))
        );
    }

    private void test(TreeNode given, List<List<Integer>> expected) {
        // when
        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> actual = binaryTreeLevelOrderTraversal.levelOrder(given);

        // then
        assertThat(actual).containsOnlyElementsOf(expected);
    }
}