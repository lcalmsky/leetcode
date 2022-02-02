package io.lcalmsky.leetcode.find_all_anagram_in_a_string;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenTwoStrings_whenFindAnagram_thenCorrect() {
    assertAll(
        () -> test("cbaebabacd", "abc", List.of(0, 6)),
        () -> test("abab", "ab", List.of(0, 1, 2))
    );
  }

  private void test(String s, String p, List<Integer> expected) {
    // when
    Solution findAllAnagramInAString = new Solution();
    List<Integer> actual = findAllAnagramInAString.findAnagrams(s, p);

    // then
    assertEquals(expected, actual);
  }
}