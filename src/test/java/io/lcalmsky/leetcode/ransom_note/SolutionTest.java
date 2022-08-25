package io.lcalmsky.leetcode.ransom_note;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test("a", "b", false),
        () -> test("aa", "ab", false),
        () -> test("aa", "aab", true)
    );
  }

  private void test(String ransomNote, String magazine, boolean expected) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.canConstruct(ransomNote, magazine);
    // then
    assertEquals(expected, actual);
  }
}