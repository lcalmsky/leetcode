package io.lcalmsky.leetcode.delete_node_in_a_bst;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.lcalmsky.leetcode.TreeNode;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SolutionTest {

  @Test
  void givenBstNode_whenDeleteNode_thenCorrect() {
    assertAll(
        () -> test(TreeNode.of(5, 3, 6, 2, 4, null, 7), 3,
            List.of(TreeNode.of(5, 4, 6, 2, null, null, 7), TreeNode.of(5, 2, 6, null, 4, null, 7)))
    );
  }

  private void test(TreeNode given, int key, List<TreeNode> expected) {
    // when
    Solution deleteNodeInABst = new Solution();
    TreeNode actual = deleteNodeInABst.deleteNode(given, key);

    // then
    assertTrue(expected.contains(actual));
  }
}
