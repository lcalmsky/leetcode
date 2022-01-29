package io.lcalmsky.leetcode.largest_rectangle_in_histogram;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenArray_whenFindLargestRectangle_thenCorrect() {
    assertAll(
        () -> test(new int[]{2, 1, 5, 6, 2, 3}, 10)
//        () -> test(new int[]{1}, 1),
//        () -> test(new int[]{4, 2}, 4),
//        () -> test(new int[]{0, 9}, 9),
//        () -> test(new int[]{0, 0}, 0),
//        () -> test(new int[]{2, 0, 2}, 2)
    );
  }

  private void test(int[] given, int expected) {
    // when
    AnotherSolution solution = new AnotherSolution();
    int actual = solution.largestRectangleArea(given);
    // then
    assertEquals(expected, actual);
  }
}