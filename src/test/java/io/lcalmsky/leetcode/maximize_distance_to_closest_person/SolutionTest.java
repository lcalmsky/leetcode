package io.lcalmsky.leetcode.maximize_distance_to_closest_person;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenSeats_whenFindMaxDistanceToClosestPerson_thenCorrect() {
    assertAll(
        () -> test(new int[]{1, 0, 0, 0, 1, 0, 1}, 2),
        () -> test(new int[]{1, 0, 0, 0}, 3),
        () -> test(new int[]{0, 1}, 1)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.maxDistToClosest(given);
    // then
    assertEquals(expected, actual);
  }
}