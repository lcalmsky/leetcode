package io.lcalmsky.leetcode.perfect_squares;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenNumber_whenFindLeastNumber_thenCorrect() {
        assertAll(
                () -> test(12, 3),
                () -> test(13, 2)
        );
    }

    private void test(int given, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.numSquares(given);

        // then
        assertEquals(actual, expected);
    }
}