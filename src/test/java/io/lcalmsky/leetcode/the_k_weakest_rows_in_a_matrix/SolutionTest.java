package io.lcalmsky.leetcode.the_k_weakest_rows_in_a_matrix;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[][]{{1, 1, 0, 0, 0},
            {1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {1, 1, 1, 1, 1}}, 3, new int[]{2, 0, 3}),
        () -> test(new int[][]{{1, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0}}, 2, new int[]{0, 2})
    );
  }

  private void test(int[][] mat, int k, int[] expected) {
    // when
    Solution solution = new Solution();
    int[] actual = solution.kWeakestRows(mat, k);
    // then
    assertArrayEquals(expected, actual);
  }
}