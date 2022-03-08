package io.lcalmsky.leetcode.linked_list_cycle;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> {
          ListNode head = ListNode.of(3);
          ListNode next = ListNode.of(2, 0);
          ListNode last = ListNode.of(-4);
          head.next = next;
          next.next = last;
          last.next = next;
          test(head, true);
        },
        () -> {
          ListNode head = ListNode.of(1);
          ListNode last = ListNode.of(2);
          head.next = last;
          last.next = head;
          test(head, true);
        },
        () -> {
          ListNode head = ListNode.of(1);
          test(head, false);
        }
    );
  }

  private void test(ListNode given, boolean expected) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.hasCycle(given);
    // then
    assertEquals(expected, actual);
  }
}