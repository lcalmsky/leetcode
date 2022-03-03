package io.lcalmsky.leetcode.arithmetic_slices;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenArray_whenSplit_thenArithmeticSlices() {
    assertAll(
        () -> test(new int[]{1, 2, 3, 4}, 3)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.numberOfArithmeticSlices(given);
    // then
    assertEquals(expected, actual);
  }
}