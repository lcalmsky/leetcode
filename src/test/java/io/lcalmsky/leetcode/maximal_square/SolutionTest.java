package io.lcalmsky.leetcode.maximal_square;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenMatrix_whenFindMaximalSquare_thenCorrect() {
    assertAll(
        () -> test(new char[][]{
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        }, 4),
        () -> test(new char[][]{
            {'0', '1'}
        }, 1)
    );
  }

  private void test(char[][] matrix, int expected) {
    // when
    Solution maximalSquare = new Solution();
    int actual = maximalSquare.maximalSquare(matrix);

    // then
    assertEquals(expected, actual);
  }
}