package io.lcalmsky.leetcode.unique_paths;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenMatrixSize_whenCountUniquePaths_thenCorrect() {
    assertAll(
        () -> test(3, 2, 3),
        () -> test(7, 3, 28)
    );
  }

  private void test(int givenN, int givenM, int expected) {
    // when
    Solution uniquePaths = new Solution();
    int actual = uniquePaths.uniquePaths(givenN, givenM);

    // then
    assertEquals(expected, actual);
  }
}