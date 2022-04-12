package io.lcalmsky.leetcode.game_of_life;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}},
            new int[][]{{0, 0, 0}, {1, 0, 1}, {0, 1, 1}, {0, 1, 0}}),
        () -> test(new int[][]{{1, 1}, {1, 0}}, new int[][]{{1, 1}, {1, 1}})
    );
  }

  private void test(int[][] given, int[][] expected) {
    // when
    Solution solution = new Solution();
    solution.gameOfLife(given);
    // then
    assertArrayEquals(expected, given);
  }
}