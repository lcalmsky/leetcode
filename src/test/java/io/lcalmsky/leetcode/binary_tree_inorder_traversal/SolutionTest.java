package io.lcalmsky.leetcode.binary_tree_inorder_traversal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenTree_whenInorderTravel_thenCorrect() {
    assertAll(
        () -> test(TreeNode.of(1, null, 2, 3), Arrays.asList(1, 3, 2))
    );
  }

  private void test(TreeNode given, List<Integer> expected) {
    // when
    Solution binaryTreeInorderTraversal = new Solution();
    List<Integer> actual = binaryTreeInorderTraversal.inorderTraversal(given);
    // then
    assertEquals(expected, actual);
  }
}