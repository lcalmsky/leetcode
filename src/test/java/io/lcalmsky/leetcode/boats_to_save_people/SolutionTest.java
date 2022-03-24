package io.lcalmsky.leetcode.boats_to_save_people;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 2}, 3, 1),
        () -> test(new int[]{3, 2, 2, 1}, 3, 3),
        () -> test(new int[]{3, 5, 3, 4}, 5, 4)
    );
  }

  private void test(int[] people, int limit, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.numRescueBoats(people, limit);
    // then
    assertEquals(expected, actual);
  }
}