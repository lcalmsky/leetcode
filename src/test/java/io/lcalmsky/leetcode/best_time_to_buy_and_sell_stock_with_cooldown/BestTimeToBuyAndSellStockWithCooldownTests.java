package io.lcalmsky.leetcode.best_time_to_buy_and_sell_stock_with_cooldown;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestTimeToBuyAndSellStockWithCooldownTests {
    @Test
    public void givenArray_whenBuyAndSellStockWithCooldown_thenGetMaximumProfit() {
        assertAll(
                () -> test(new int[]{1, 2, 3, 0, 2}, 3)
        );
    }

    private void test(int[] given, int expected) {
        // when
        Solution bestTimeToBuyAndSellStockWithCooldown = new Solution();
        int actual = bestTimeToBuyAndSellStockWithCooldown.maxProfit(given);

        // then
        assertEquals(expected, actual);
    }
}
