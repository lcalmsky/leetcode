package io.lcalmsky.leetcode.unique_morse_code_words;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new String[]{"gin", "zen", "gig", "msg"}, 2),
        () -> test(new String[]{"a"}, 1)
    );
  }

  private void test(String[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.uniqueMorseRepresentations(given);
    // then
    assertEquals(expected, actual);
  }
}