package io.lcalmsky.leetcode.matchsticks_to_square;

import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.function.Consumer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 1, 2, 2, 2}, Assertions::assertTrue),
        () -> test(new int[]{3, 3, 3, 3, 4}, Assertions::assertFalse)
    );
  }

  private void test(int[] given, Consumer<Boolean> consumer) {
    Solution solution = new Solution();
    boolean actual = solution.makesquare(given);
    consumer.accept(actual);
  }
}