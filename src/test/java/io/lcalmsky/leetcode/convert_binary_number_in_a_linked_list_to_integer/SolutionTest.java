package io.lcalmsky.leetcode.convert_binary_number_in_a_linked_list_to_integer;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(ListNode.of(1, 0, 1), 5),
        () -> test(ListNode.of(0), 0),
        () -> test(ListNode.of(1), 1),
        () -> test(ListNode.of(1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0), 18880),
        () -> test(ListNode.of(0, 0), 0)
    );
  }

  private void test(ListNode given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.getDecimalValue(given);
    // then
    assertEquals(expected, actual);
  }
}