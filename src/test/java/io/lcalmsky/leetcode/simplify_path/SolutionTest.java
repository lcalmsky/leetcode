package io.lcalmsky.leetcode.simplify_path;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test("/home/", "/home"),
        () -> test("/../", "/"),
        () -> test("/home//foo/", "/home/foo")
    );
  }

  private void test(String given, String expected) {
    // when
    Solution solution = new Solution();
    String actual = solution.simplifyPath(given);
    // then
    assertEquals(expected, actual);
  }
}