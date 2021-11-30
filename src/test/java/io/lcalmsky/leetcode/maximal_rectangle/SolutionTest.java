package io.lcalmsky.leetcode.maximal_rectangle;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenArray_whenGetMaximalRectangleArea_thenCorrect() {
    assertAll(
        () -> test(new char[][]{
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        }, 6),
        () -> test(new char[][]{}, 0),
        () -> test(new char[][]{{'0'}}, 0),
        () -> test(new char[][]{{'1'}}, 1),
        () -> test(new char[][]{{'0', '0'}}, 0)
    );
  }

  private void test(char[][] given, int expected) {
    // when
    Solution maximalRectangle = new AnotherSolution();
    int actual = maximalRectangle.maximalRectangle(given);

    // then
    assertEquals(expected, actual);
  }
}