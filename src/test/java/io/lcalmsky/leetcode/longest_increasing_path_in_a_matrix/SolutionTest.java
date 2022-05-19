package io.lcalmsky.leetcode.longest_increasing_path_in_a_matrix;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}, 4),
        () -> test(new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}}, 4),
        () -> test(new int[][]{{1}}, 1)
    );
  }

  private void test(int[][] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.longestIncreasingPath(given);
    // then
    assertEquals(expected, actual);
  }
}