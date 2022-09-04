package io.lcalmsky.leetcode.add_strings;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenTwoStrings_whenAddThem_thenCorrect() {
    assertAll(
        () -> test("11", "123", "134"),
        () -> test("456", "77", "533"),
        () -> test("0", "0", "0")
    );
  }

  private void test(String num1, String num2, String expected) {
    // when
    Solution addStrings = new Solution();
    String actual = addStrings.addStrings(num1, num2);

    // then
    assertEquals(expected, actual);
  }

}