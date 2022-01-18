package io.lcalmsky.leetcode.can_place_flowers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenFlowerbedAndNumberOfNewFlowers_whenPlaceNewFlowerWithoutAdjacent_thenCorrect() {
    // then
    assertAll(
        () -> assertTrue(test(new int[]{1, 0, 0, 0, 1}, 1)),
        () -> assertFalse(test(new int[]{1, 0, 0, 0, 1}, 2))
    );
  }

  private boolean test(int[] given, int n) {
    // when
    Solution solution = new Solution();
    return solution.canPlaceFlowers(given, n);
  }
}