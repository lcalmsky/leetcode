package io.lcalmsky.leetcode.best_time_to_buy_and_sell_stock_iii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BestTimeToBuyAndSellStock3Tests {
    @Test
    public void givenArray_whenFindMaxProfit_thenCorrect() {
        assertAll(
                () -> test(new int[]{3, 3, 5, 0, 0, 3, 1, 4}, 6),
                () -> test(new int[]{1, 2, 3, 4, 5}, 4),
                () -> test(new int[]{7, 6, 4, 3, 1}, 0)
        );
    }

    private void test(int[] given, int expected) {
        // when
        BestTimeToBuyAndSellStock3 bestTimeToBuyAndSellStock3 = new BestTimeToBuyAndSellStock3();
        int actual = bestTimeToBuyAndSellStock3.maxProfit(given);

        // then
        assertEquals(expected, actual);
    }
}
