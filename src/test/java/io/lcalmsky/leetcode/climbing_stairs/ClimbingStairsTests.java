package io.lcalmsky.leetcode.climbing_stairs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClimbingStairsTests {
    @Test
    public void givenInteger_whenClimbStairs_thenCorrect() {
        assertAll(
                () -> test(2, 2),
                () -> test(3, 3)
        );
    }

    private void test(int given, int expected) {
        // when
        Solution climbingStairs = new Solution();
        int actual = climbingStairs.climbStairs(given);

        // then
        assertEquals(expected, actual);

        // log
        System.out.println(actual);
    }
}
