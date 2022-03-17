package io.lcalmsky.leetcode.score_of_parentheses;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenParentheses_whenCompute_thenCorrect() {
    assertAll(
        () -> test("()", 1),
        () -> test("(())", 2),
        () -> test("()()", 2),
        () -> test("(()(()))", 6)
    );
  }

  private void test(String given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.scoreOfParentheses(given);

    // then
    assertEquals(expected, actual);
  }
}
