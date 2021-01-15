package io.lcalmsky.leetcode.pattern_of_132;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatternOf132Tests {
    @Test
    public void givenNumbers_whenFind132Pattern_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 2, 3, 4}, false),
                () -> test(new int[]{3, 1, 4, 2}, true),
                () -> test(new int[]{-1, 3, 2, 0}, true)
        );
    }

    private void test(int[] given, boolean expected) {
        // when
        Solution patternOf132 = new Solution();
        boolean actual = patternOf132.find132pattern(given);

        // then
        assertEquals(expected, actual);
    }
}
