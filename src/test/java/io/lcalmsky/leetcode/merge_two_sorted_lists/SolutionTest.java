package io.lcalmsky.leetcode.merge_two_sorted_lists;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(ListNode.of(1, 2, 4), ListNode.of(1, 3, 4), ListNode.of(1, 1, 2, 3, 4, 4)),
        () -> test(null, null, null),
        () -> test(null, ListNode.of(0), ListNode.of(0))
    );
  }

  private void test(ListNode list1, ListNode list2, ListNode expected) {
    // when
    Solution solution = new Solution();
    ListNode actual = solution.mergeTwoLists(list1, list2);
    // then
    assertEquals(expected, actual);
  }
}