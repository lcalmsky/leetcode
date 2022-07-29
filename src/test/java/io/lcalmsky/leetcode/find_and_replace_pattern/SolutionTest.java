package io.lcalmsky.leetcode.find_and_replace_pattern;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb",
            List.of("mee", "aqq")),
        () -> test(new String[]{"a", "b", "c"}, "a", List.of("a", "b", "c"))
    );
  }

  private void test(String[] words, String pattern, List<String> expected) {
    // when
    Solution solution = new Solution();
    List<String> actual = solution.findAndReplacePattern(words, pattern);
    // then
    assertEquals(expected, actual);
  }
}