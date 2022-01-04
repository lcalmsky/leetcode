package io.lcalmsky.leetcode.complement_of_base_10_integer;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void bitwiseComplement() {
    assertAll(
        () -> test(5, 2),
        () -> test(7, 0),
        () -> test(10, 5)
    );
  }

  private void test(int given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.bitwiseComplement(given);
    // then
    assertEquals(expected, actual);
  }
}