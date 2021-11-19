package io.lcalmsky.leetcode.hamming_distance;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenNumbers_whenFindHammingDistance_thenCorrect() {
    assertAll(
        () -> test(1, 4, 2)
    );
  }

  private void test(int x, int y, int expected) {
    // when
    Solution hammingDistance = new Solution();
    int actual = hammingDistance.hammingDistance(x, y);

    // then
    assertEquals(expected, actual);
  }
}