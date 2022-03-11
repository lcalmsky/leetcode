package io.lcalmsky.leetcode.add_two_numbers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(ListNode.of(2, 4, 3), ListNode.of(5, 6, 4), ListNode.of(7, 0, 8)),
        () -> test(ListNode.of(0), ListNode.of(0), ListNode.of(0)),
        () -> test(ListNode.of(9, 9, 9, 9, 9, 9, 9), ListNode.of(9, 9, 9, 9),
            ListNode.of(8, 9, 9, 9, 0, 0, 0, 1))
    );
  }

  private void test(ListNode l1, ListNode l2, ListNode expected) {
    // when
    Solution solution = new Solution();
    ListNode actual = solution.addTwoNumbers(l1, l2);
    // then
    assertEquals(expected, actual);
  }
}