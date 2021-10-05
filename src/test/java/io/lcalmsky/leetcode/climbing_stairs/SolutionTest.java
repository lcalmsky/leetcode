package io.lcalmsky.leetcode.climbing_stairs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenInteger_whenClimbStairs_thenCorrect() {
        assertAll(
                () -> test(2, 2),
                () -> test(3, 3)
        );
    }

    private void test(int given, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.climbStairs(given);

        // then
        assertEquals(expected, actual);
    }
}