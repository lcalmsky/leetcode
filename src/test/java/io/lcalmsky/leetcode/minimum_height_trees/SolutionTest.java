package io.lcalmsky.leetcode.minimum_height_trees;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenEdgesAndNumberOfNodes_whenFindRootNodeWithMinimumHeightTree_thenCorrect() {
    assertAll(
        () -> test(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}, List.of(1)),
        () -> test(6, new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}}, List.of(3, 4)),
        () -> test(1, new int[][]{}, List.of(0))
    );
  }

  private void test(int n, int[][] edges, List<Integer> expected) {
    // when
    Solution minimumHeightTrees = new Solution();
    List<Integer> actual = minimumHeightTrees.findMinHeightTrees(n, edges);
    // then
    assertEquals(expected, actual);
  }
}