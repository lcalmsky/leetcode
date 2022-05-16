package io.lcalmsky.leetcode.shortest_path_in_binary_matrix;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[][]{
            {0, 1}, {1, 0}
        }, 2),
        () -> test(new int[][]{
            {0, 0, 0}, {1, 1, 0}, {1, 1, 0}
        }, 4),
        () -> test(new int[][]{
            {1, 0, 0}, {1, 1, 0}, {1, 1, 0}
        }, -1)
    );
  }

  private void test(int[][] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.shortestPathBinaryMatrix(given);
    // then
    assertEquals(expected, actual);
  }
}