package io.lcalmsky.leetcode.middle_of_the_linked_list;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(ListNode.of(1, 2, 3, 4, 5), ListNode.of(3, 4, 5)),
        () -> test(ListNode.of(1, 2, 3, 4, 5, 6), ListNode.of(4, 5, 6))
    );
  }

  private void test(ListNode given, ListNode expected) {
    // when
    Solution solution = new Solution();
    ListNode actual = solution.middleNode(given);
    // then
    assertEquals(expected, actual);
  }
}