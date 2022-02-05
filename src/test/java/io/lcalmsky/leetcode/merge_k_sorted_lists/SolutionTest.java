package io.lcalmsky.leetcode.merge_k_sorted_lists;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.ListNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new ListNode[]{ListNode.of(1, 4, 5), ListNode.of(1, 3, 4), ListNode.of(2, 6)},
            ListNode.of(1, 1, 2, 3, 4, 4, 5, 6)),
        () -> test(new ListNode[]{}, null)
    );
  }

  private void test(ListNode[] given, ListNode expected) {
    // when
    Solution solution = new Solution();
    ListNode actual = solution.mergeKLists(given);
    // then
    assertEquals(expected, actual);
  }
}