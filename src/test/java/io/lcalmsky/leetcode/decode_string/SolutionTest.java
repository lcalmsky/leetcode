package io.lcalmsky.leetcode.decode_string;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenString_whenDecode_thenCorrect() {
    assertAll(
        () -> test("3[a]2[bc]", "aaabcbc"),
        () -> test("3[a2[c]]", "accaccacc"),
        () -> test("2[abc]3[cd]ef", "abcabccdcdcdef"),
        () -> test("abc3[cd]xyz", "abccdcdcdxyz")
    );
  }

  private void test(String given, String expected) {
    // when
    Solution decodeString = new Solution();
    String actual = decodeString.decodeString(given);
    // then
    assertEquals(expected, actual);
  }
}