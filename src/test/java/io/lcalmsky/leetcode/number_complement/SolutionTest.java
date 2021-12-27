package io.lcalmsky.leetcode.number_complement;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenNumber_whenFindComplement_thenCorrect() {
    assertAll(
        () -> test(5, 2),
        () -> test(1, 0)
    );
  }

  private void test(int given, int expected) {
    // when
    Solution numberComplement = new Solution();
    int actual = numberComplement.findComplement(given);

    // then
    assertEquals(expected, actual);
  }
}