package io.lcalmsky.leetcode.minimum_number_of_arrows_to_burst_balloons;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SolutionTest {

  @Test
  void givenBalloons_whenShotArrows_thenBurstsWithMinimumNumber() {
    assertAll(
        () -> test(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}, 2),
        () -> test(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}, 4),
        () -> test(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}, 2)
    );
  }

  private void test(int[][] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.findMinArrowShots(given);
    // then
    assertEquals(expected, actual);
  }
}
