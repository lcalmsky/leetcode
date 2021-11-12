package io.lcalmsky.leetcode.remove_linked_list_elements;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenLinkedList_whenRemoveElements_thenCorrect() {
    assertAll(
        () -> test(ListNode.of(1, 2, 6, 3, 4, 5, 6), 6, ListNode.of(1, 2, 3, 4, 5))
    );
  }

  private void test(ListNode given, int val, ListNode expected) {
    // when
    Solution removeLinkedListElements = new Solution();
    ListNode actual = removeLinkedListElements.removeElements(given, val);

    // then
    assertEquals(expected, actual);
  }
}