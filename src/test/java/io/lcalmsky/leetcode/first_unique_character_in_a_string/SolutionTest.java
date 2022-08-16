package io.lcalmsky.leetcode.first_unique_character_in_a_string;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenString_findFirstUniqueCharacter_thenCorrect() {
    assertAll(
        () -> test("leetcode", 0),
        () -> test("loveleetcode", 2),
        () -> test("aabb", -1)
    );
  }

  private void test(String given, int expected) {
    // when
    Solution firstUniqueCharacterInAString = new Solution();
    int actual = firstUniqueCharacterInAString.firstUniqChar(given);
    // then
    assertEquals(expected, actual);
  }
}