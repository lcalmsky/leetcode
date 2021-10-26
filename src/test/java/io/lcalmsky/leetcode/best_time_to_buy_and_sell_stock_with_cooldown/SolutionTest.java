package io.lcalmsky.leetcode.best_time_to_buy_and_sell_stock_with_cooldown;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenArray_whenBuyAndSellStockWithCooldown_thenGetMaximumProfit() {
        assertAll(
                () -> test(new int[]{1, 2, 3, 0, 2}, 3),
                () -> test(new int[]{1}, 0)
        );
    }

    private void test(int[] given, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.maxProfit(given);

        // then
        assertEquals(expected, actual);
    }
}