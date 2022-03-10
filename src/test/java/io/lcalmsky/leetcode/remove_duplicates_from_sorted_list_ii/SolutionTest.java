package io.lcalmsky.leetcode.remove_duplicates_from_sorted_list_ii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(ListNode.of(1, 2, 3, 3, 4, 4, 5), ListNode.of(1, 2, 5)),
        () -> test(ListNode.of(1, 1, 1, 2, 3), ListNode.of(2, 3))
    );
  }

  private void test(ListNode given, ListNode expected) {
    // when
    Solution solution = new Solution();
    ListNode actual = solution.deleteDuplicates(given);
    // then
    assertEquals(expected, actual);
  }
}