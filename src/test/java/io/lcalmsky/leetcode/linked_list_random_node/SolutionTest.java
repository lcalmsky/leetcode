package io.lcalmsky.leetcode.linked_list_random_node;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.lcalmsky.leetcode.ListNode;
import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void test() {
    Solution solution = new Solution(ListNode.of(1, 2, 3));
    List<Integer> list = List.of(1, 2, 3);
    assertTrue(list.contains(solution.getRandom()));
    assertTrue(list.contains(solution.getRandom()));
    assertTrue(list.contains(solution.getRandom()));
  }
}