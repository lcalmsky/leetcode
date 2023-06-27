package io.lcalmsky.leetcode.search_a_2d_matrix;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenMatrix_whenSearchesTarget_thenReturnsWhetherExists() {
    assertAll(
        () -> test(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 3, true),
        () -> test(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 13, false)
    );
  }

  private void test(int[][] givenArray, int givenTarget, boolean expected) {
    // when
    Solution searchA2dMatrix = new Solution();
    boolean actual = searchA2dMatrix.searchMatrix(givenArray, givenTarget);

    // then
    assertEquals(expected, actual);
  }
}