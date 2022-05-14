package io.lcalmsky.leetcode.network_delay_time;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2, 2),
        () -> test(new int[][]{{1, 2, 1}}, 2, 1, 1),
        () -> test(new int[][]{{1, 2, 1}}, 2, 2, -1)
    );
  }

  private void test(int[][] times, int n, int k, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.networkDelayTime(times, n, k);
    // then
    assertEquals(expected, actual);
  }
}