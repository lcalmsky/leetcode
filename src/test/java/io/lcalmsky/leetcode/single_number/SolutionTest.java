package io.lcalmsky.leetcode.single_number;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenArray_whenFindUniqueNumber_thenCorrect() {
    assertAll(
//        () -> test(new int[]{2, 2, 1}, 1),
        () -> test(new int[]{4, 1, 2, 1, 2}, 4)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution singleNumber = new Solution();
    int actual = singleNumber.singleNumber(given);
    // then
    assertEquals(expected, actual);
  }
}