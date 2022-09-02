package io.lcalmsky.leetcode.average_of_levels_in_binary_tree;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenNonEmptyBinaryTree_whenFindAverageOfLevelsInTheTree_thenCorrect() {
    assertAll(
        () -> test(TreeNode.of(3, 9, 20, null, null, 15, 7), Arrays.asList(3d, 14.5d, 11d))
    );
  }

  private void test(TreeNode given, List<Double> expected) {
    // when
    Solution averageOfLevelsInBinaryTree = new Solution();
    List<Double> actual = averageOfLevelsInBinaryTree.averageOfLevels(given);

    // then
    assertEquals(expected, actual);
  }
}