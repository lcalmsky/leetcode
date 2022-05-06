package io.lcalmsky.leetcode.remove_all_adjacent_duplicates_in_string_ii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test("abcd", 2, "abcd"),
        () -> test("deeedbbcccbdaa", 3, "aa"),
        () -> test("pbbcggttciiippooaais", 2, "ps")
    );
  }

  private void test(String given, int k, String expected) {
    // when
    Solution solution = new Solution();
    String actual = solution.removeDuplicates(given, k);
    // then
    assertEquals(expected, actual);
  }
}