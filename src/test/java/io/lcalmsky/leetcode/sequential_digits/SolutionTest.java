package io.lcalmsky.leetcode.sequential_digits;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(100, 300, List.of(123, 234)),
        () -> test(58, 155, List.of(67, 78, 89, 123)),
        () -> test(1000, 13000, List.of(1234, 2345, 3456, 4567, 5678, 6789, 12345))
    );
  }

  private void test(int low, int high, List<Integer> expected) {
    // when
    Solution solution = new Solution();
    List<Integer> actual = solution.sequentialDigits(low, high);
    // then
    assertEquals(expected, actual);
  }
}