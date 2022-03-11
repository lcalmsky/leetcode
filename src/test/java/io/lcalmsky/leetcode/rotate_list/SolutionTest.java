package io.lcalmsky.leetcode.rotate_list;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(ListNode.of(1, 2, 3, 4, 5), 2, ListNode.of(4, 5, 1, 2, 3)),
        () -> test(ListNode.of(0, 1, 2), 4, ListNode.of(2, 0, 1))
    );
  }

  private void test(ListNode head, int k, ListNode expected) {
    // when
    Solution solution = new Solution();
    ListNode actual = solution.rotateRight(head, k);
    // then
    assertEquals(expected, actual);
  }
}