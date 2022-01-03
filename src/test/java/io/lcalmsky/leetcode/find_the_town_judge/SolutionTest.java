package io.lcalmsky.leetcode.find_the_town_judge;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(2, new int[][]{{1, 2}}, 2),
        () -> test(3, new int[][]{{1, 3}, {2, 3}}, 3),
        () -> test(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}, -1)
    );
  }

  private void test(int n, int[][] trust, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.findJudge(n, trust);
    // then
    assertEquals(expected, actual);
  }
}