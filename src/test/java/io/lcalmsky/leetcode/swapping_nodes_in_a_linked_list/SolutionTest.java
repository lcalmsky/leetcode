package io.lcalmsky.leetcode.swapping_nodes_in_a_linked_list;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(ListNode.of(1, 2, 3, 4, 5), 2, ListNode.of(1, 4, 3, 2, 5)),
        () -> test(ListNode.of(7, 9, 6, 6, 7, 8, 3, 0, 9, 5), 5,
            ListNode.of(7, 9, 6, 6, 8, 7, 3, 0, 9, 5))
    );
  }

  private void test(ListNode head, int k, ListNode expected) {
    // when
    Solution solution = new Solution();
    ListNode actual = solution.swapNodes(head, k);
    // then
    assertEquals(expected, actual);
  }
}