package io.lcalmsky.leetcode.best_time_to_buy_and_sell_stock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestTimeToBuyAndSellStockTests {
    @Test
    public void givenArray_whenFindMaxProfit_thenCorrect() {
        assertAll(
                () -> test(new int[]{7, 1, 5, 3, 6, 4}, 5),
                () -> test(new int[]{7, 6, 4, 3, 1}, 0),
                () -> test(new int[]{2, 1, 4}, 3),
                () -> test(new int[]{1, 4, 2}, 3)
        );
    }

    private void test(int[] given, int expected) {
        // when
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        int actual = bestTimeToBuyAndSellStock.maxProfit(given);

        // then
        assertEquals(expected, actual);
    }
}