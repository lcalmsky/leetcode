package io.lcalmsky.leetcode.reverse_linked_list_ii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenLinkedList_whenReverse_thenCorrect() {
    assertAll(
        () -> test(ListNode.of(1, 2, 3, 4, 5), 2, 4, ListNode.of(1, 4, 3, 2, 5)),
        () -> test(ListNode.of(3, 5), 1, 1, ListNode.of(3, 5))
    );
  }

  private void test(ListNode given, int m, int n, ListNode expected) {
    // when
    Solution reverseLinkedList2 = new Solution();
    ListNode actual = reverseLinkedList2.reverseBetween(given, m, n);

    // then
    assertEquals(expected, actual);
  }
}