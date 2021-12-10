package io.lcalmsky.leetcode.domino_and_tromino_tiling;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(3, 5),
        () -> test(1, 1),
        () -> test(30, 312342182)
    );
  }

  private void test(int given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.numTilings(given);
    // then
    assertEquals(expected, actual);
  }
}