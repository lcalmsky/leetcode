package io.lcalmsky.leetcode.binary_tree_preorder_traversal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenTreeNode_whenPreorderTraverse_thenCorrect() {
    assertAll(
        () -> test(TreeNode.of(1, null, 2, 3), Arrays.asList(1, 2, 3))
    );
  }

  private void test(TreeNode given, List<Integer> expected) {
    // when
    Solution binaryTreePreorderTraversal = new Solution();
    List<Integer> actual = binaryTreePreorderTraversal.preorderTraversal(given);

    // then
    assertEquals(expected, actual);
  }
}