package io.lcalmsky.leetcode.burst_balloons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BurstBalloonsTests {
    @Test
    public void givenArray_whenBurstBalloons_thenGetMaximumCoins() {
        assertAll(
                () -> test(new int[]{3, 1, 5, 8}, 167)
        );
    }

    private void test(int[] given, int expected) {
        // when
        Solution burstBalloons = new Solution();
        int actual = burstBalloons.maxCoins(given);

        // then
        assertEquals(expected, actual);
    }
}
