package io.lcalmsky.leetcode.palindrome_partitioning;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenString_whenGetPalindromePartition_thenCorrect() {
    assertAll(
        () -> test("aab", List.of(
            List.of("aa", "b"),
            List.of("a", "a", "b")
        )),
        () -> test("a", List.of(List.of("a")))
    );
  }

  private void test(String given, List<List<String>> expected) {
    // when
    Solution solution = new Solution();
    List<List<String>> actual = solution.partition(given);
    // then
    assertThat(actual).containsAll(expected);
  }
}