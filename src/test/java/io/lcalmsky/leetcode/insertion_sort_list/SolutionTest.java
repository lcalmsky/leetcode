package io.lcalmsky.leetcode.insertion_sort_list;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(ListNode.of(4, 2, 1, 3), ListNode.of(1, 2, 3, 4)),
        () -> test(ListNode.of(-1, 5, 3, 4, 0), ListNode.of(-1, 0, 3, 4, 5))
    );
  }

  private void test(ListNode given, ListNode expected) {
    // when
    Solution solution = new Solution();
    ListNode actual = solution.insertionSortList(given);
    // then
    assertEquals(expected, actual);
  }
}