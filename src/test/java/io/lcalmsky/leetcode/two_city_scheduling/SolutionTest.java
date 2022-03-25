package io.lcalmsky.leetcode.two_city_scheduling;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}, 110),
        () -> test(
            new int[][]{{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}},
            1859),
        () -> test(
            new int[][]{{515, 563}, {451, 713}, {537, 709}, {343, 819}, {855, 779}, {457, 60},
                {650, 359},
                {631, 42}}, 3086)
    );
  }

  private void test(int[][] costs, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.twoCitySchedCost(costs);
    // then
    assertEquals(expected, actual);
  }
}