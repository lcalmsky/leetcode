package io.lcalmsky.leetcode.gas_station;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenGasAndCostArrays_whenFindStartIndex_thenCorrect() {
    assertAll(
        () -> test(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}, 3),
        () -> test(new int[]{2, 3, 4}, new int[]{3, 4, 3}, -1),
        () -> test(new int[]{4, 5, 2, 6, 5, 3}, new int[]{3, 2, 7, 3, 2, 9}, -1)
    );
  }

  private void test(int[] gas, int[] cost, int expected) {
    // when
    Solution gasStation = new Solution();
    int actual = gasStation.canCompleteCircuit(gas, cost);
    // then
    assertEquals(expected, actual);
  }
}