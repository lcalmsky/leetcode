package io.lcalmsky.leetcode.partition_list;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(ListNode.of(1, 4, 3, 2, 5, 2), 3, ListNode.of(1, 2, 2, 4, 3, 5)),
        () -> test(ListNode.of(2, 1), 2, ListNode.of(1, 2))
    );
  }

  private void test(ListNode given, int x, ListNode expected) {
    // when
    Solution solution = new Solution();
    ListNode actual = solution.partition(given, x);
    // then
    assertEquals(expected, actual);
  }
}