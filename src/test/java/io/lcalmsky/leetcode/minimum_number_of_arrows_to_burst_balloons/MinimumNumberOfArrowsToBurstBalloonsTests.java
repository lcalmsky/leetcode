package io.lcalmsky.leetcode.minimum_number_of_arrows_to_burst_balloons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumNumberOfArrowsToBurstBalloonsTests {
    @Test
    public void givenBalloons_whenShotArrows_thenBurstsWithMinimumNumber() {
        assertAll(
                () -> test(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}, 2)
        );
    }

    private void test(int[][] given, int expected) {
        // when
        Solution minimumNumberOfArrowsToBurstBalloons = new Solution();
        int actual = minimumNumberOfArrowsToBurstBalloons.findMinArrowShots(given);

        // then
        assertEquals(expected, actual);
    }
}
