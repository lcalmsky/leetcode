package io.lcalmsky.leetcode.maximum_xor_of_two_numbers_in_an_array;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenArray_whenXor_thenFindMaximum() {
    assertAll(
//        () -> test(new int[]{3, 10, 5, 25, 2, 8}, 28),
        () -> test(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70}, 127)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.findMaximumXOR(given);
    // then
    assertEquals(expected, actual);
  }
}