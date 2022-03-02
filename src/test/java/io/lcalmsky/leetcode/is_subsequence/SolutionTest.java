package io.lcalmsky.leetcode.is_subsequence;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenTwoStrings_whenFindOneIsSubsequenceOfAnother_thenCorrect() {
    assertAll(
        () -> test("abc", "ahbgdc", true, new Solution()),
        () -> test("axc", "ahbgdc", false, new Solution()),
        () -> test("abc", "ahbgdc", true, new Solution2()),
        () -> test("axc", "ahbgdc", false, new Solution2()),
        () -> test("abc", "ahbgdc", true, new Solution3()),
        () -> test("axc", "ahbgdc", false, new Solution3())
    );
  }

  private void test(String s, String t, boolean expected, Solution solution) {
    // when
    boolean actual = solution.isSubsequence(s, t);
    // then
    assertEquals(expected, actual);
  }
}