package io.lcalmsky.leetcode.reverse_string;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new char[]{'h', 'e', 'l', 'l', 'o'}, new char[]{'o', 'l', 'l', 'e', 'h'}),
        () -> test(new char[]{'H', 'a', 'n', 'n', 'a', 'h'},
            new char[]{'h', 'a', 'n', 'n', 'a', 'H'})
    );
  }

  private void test(char[] given, char[] expected) {
    // when
    Solution solution = new Solution();
    solution.reverseString(given);
    // then
    assertArrayEquals(expected, given);
  }
}