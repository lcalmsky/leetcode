package io.lcalmsky.leetcode.validate_stack_sequences;

import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.function.Consumer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}, Assertions::assertTrue),
        () -> test(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}, Assertions::assertFalse)
    );
  }

  private void test(int[] pushed, int[] popped, Consumer<Boolean> then) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.validateStackSequences(pushed, popped);
    // then
    then.accept(actual);
  }
}