package io.lcalmsky.leetcode.coin_change;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{1, 2, 5}, 11, 3),
                () -> test(new int[]{2}, 3, -1),
                () -> test(new int[]{1}, 0, 0)
        );
    }

    private void test(int[] coins, int amount, int expected) {
        Solution solution = new Solution();
        int actual = solution.coinChange(coins, amount);
        assertEquals(expected, actual);
    }
}