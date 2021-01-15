package io.lcalmsky.leetcode.perfect_squares;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerfectSquaresTests {
    @Test
    public void givenNumber_whenFindLeastNumber_thenCorrect() {
        assertAll(
                () -> test(12, 3),
                () -> test(13, 2)
        );
    }

    private void test(int given, int expected) {
        // when
        Solution perfectSquares = new Solution();
        int actual = perfectSquares.numSquares(given);

        // then
        assertEquals(actual, expected);
    }
}
