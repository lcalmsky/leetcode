package io.lcalmsky.leetcode.binary_tree_level_order_traversal_ii;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BinaryTreeLevelOrderTraversal2Tests {
    @Test
    public void givenBinaryTree_whenLevelOrderTraversalFromBottom_thenCorrect() {
        assertAll(
                () -> test(TreeNode.of(3, 9, 20, null, null, 15, 7),
                        Arrays.asList(
                                Arrays.asList(15, 7),
                                Arrays.asList(9, 20),
                                Collections.singletonList(3)
                        ))
        );
    }

    private void test(TreeNode given, List<List<Integer>> expected) {
        // when
        BinaryTreeLevelOrderTraversal2 binaryTreeLevelOrderTraversal2 = new BinaryTreeLevelOrderTraversal2();
        List<List<Integer>> actual = binaryTreeLevelOrderTraversal2.levelOrderBottom(given);

        // then
        assertThat(actual).containsOnlyElementsOf(expected);
    }
}
