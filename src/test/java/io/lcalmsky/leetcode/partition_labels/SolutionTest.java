package io.lcalmsky.leetcode.partition_labels;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenString_whenPartitionString_thenEachLetterAppearsMost() {
    assertAll(
        () -> test("ababcbacadefegdehijhklij", List.of(9, 7, 8)),
        () -> test("eccbbbbdec", List.of(10))
    );
  }

  private void test(String given, List<Integer> expected) {
    // when
    Solution solution = new Solution();
    List<Integer> actual = solution.partitionLabels(given);
    // then
    assertEquals(expected, actual);
  }
}
