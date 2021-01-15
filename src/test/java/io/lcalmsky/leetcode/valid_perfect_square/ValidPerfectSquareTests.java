package io.lcalmsky.leetcode.valid_perfect_square;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidPerfectSquareTests {
    @Test
    public void givenInteger_whenFindItIsPerfectSquare_thenCorrect() {
        assertAll(
                () -> test(16, true),
                () -> test(14, false)
        );
    }

    private void test(int given, boolean expected) {
        // when
        Solution validPerfectSquare = new Solution();
        boolean actual = validPerfectSquare.isPerfectSquare(given);

        // then
        assertEquals(expected, actual);
    }
}
