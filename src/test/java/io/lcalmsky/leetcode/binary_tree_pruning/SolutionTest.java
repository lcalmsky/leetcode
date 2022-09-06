package io.lcalmsky.leetcode.binary_tree_pruning;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenTreeNode_whenPrune_thenCorrect() {
    assertAll(
        () -> test(TreeNode.of(1, null, 0, 0, 1), TreeNode.of(1, null, 0, null, 1)),
        () -> test(TreeNode.of(1, 0, 1, 0, 0, 0, 1), TreeNode.of(1, null, 1, null, 1))
    );
  }

  private void test(TreeNode given, TreeNode expected) {
    // when
    Solution solution = new Solution();
    TreeNode actual = solution.pruneTree(given);

    // then
    assertEquals(expected, actual);
  }
}
