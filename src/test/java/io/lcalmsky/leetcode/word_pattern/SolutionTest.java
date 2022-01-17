package io.lcalmsky.leetcode.word_pattern;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenPatternAndWords_whenCheckPattern_thenCorrect() {
    assertAll(
        () -> test("abba", "dog cat cat dog", true),
        () -> test("abba", "dog cat cat fish", false),
        () -> test("aaaa", "dog cat cat dog", false),
        () -> test("abba", "dog dog dog dog", false)
    );
  }

  private void test(String pattern, String words, boolean expected) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.wordPattern(pattern, words);
    // then
    assertEquals(expected, actual);
  }
}