package io.lcalmsky.leetcode.swap_node_in_pairs;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(ListNode.of(1, 2, 3, 4), ListNode.of(2, 1, 4, 3)),
        () -> test(null, null),
        () -> test(ListNode.of(1), ListNode.of(1))
    );
  }

  private void test(ListNode given, ListNode expected) {
    // when
    Solution solution = new Solution();
    ListNode actual = solution.swapPairs(given);
    // then
    assertEquals(expected, actual);
  }
}