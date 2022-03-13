package io.lcalmsky.leetcode.valid_parentheses;

import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.function.Consumer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test("()", Assertions::assertTrue),
        () -> test("()[]{}", Assertions::assertTrue),
        () -> test("(]", Assertions::assertFalse)
    );
  }

  private void test(String given, Consumer<Boolean> consumer) {
    // when
    Solution solution = new Solution();
    // then
    consumer.accept(solution.isValid(given));
  }
}