package io.lcalmsky.leetcode.all_elements_in_two_binary_search_trees;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(TreeNode.of(2, 1, 4), TreeNode.of(1, 0, 3), List.of(0, 1, 1, 2, 3, 4)),
        () -> test(TreeNode.of(1, null, 8), TreeNode.of(8, 1), List.of(1, 1, 8, 8))
    );
  }

  private void test(TreeNode root1, TreeNode root2, List<Integer> expected) {
    // when
    Solution solution = new Solution();
    List<Integer> actual = solution.getAllElements(root1, root2);
    // then
    assertEquals(expected, actual);
  }
}