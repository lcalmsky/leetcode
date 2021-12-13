package io.lcalmsky.leetcode.consecutive_characters;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test("leetcode", 2),
        () -> test("abbcccddddeeeeedcba", 5),
        () -> test("triplepillooooow", 5),
        () -> test("hooraaaaaaaaaaay", 11),
        () -> test("tourist", 1)
    );
  }

  private void test(String given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.maxPower(given);
    // then
    assertEquals(expected, actual);
  }
}