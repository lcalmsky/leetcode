package io.lcalmsky.leetcode.integer_break;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegerBreakTests {
    @Test
    public void givenNumber_whenBreakInteger_thenFindMaximumValue() {
        assertAll(
                () -> test(2, 1),
                () -> test(10, 36)
        );
    }

    private void test(int given, int expected) {
        // when
        Solution integerBreak = new Solution();
        int actual = integerBreak.integerBreak(given);

        // then
        assertEquals(expected, actual);
    }
}
