package io.lcalmsky.leetcode.reorder_list;

import static org.junit.jupiter.api.Assertions.*;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(ListNode.of(1, 2, 3, 4), ListNode.of(1, 4, 2, 3)),
        () -> test(ListNode.of(1, 2, 3, 4, 5), ListNode.of(1, 5, 2, 4, 3))
    );
  }

  private void test(ListNode given, ListNode expected) {
    // when
    Solution solution = new Solution();
    solution.reorderList(given);
    // then
    assertEquals(expected, given);
  }
}