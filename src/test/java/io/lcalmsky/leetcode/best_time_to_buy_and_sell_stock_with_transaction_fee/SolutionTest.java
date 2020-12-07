package io.lcalmsky.leetcode.best_time_to_buy_and_sell_stock_with_transaction_fee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenArray_whenMakeMaximumProfit_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 3, 2, 8, 4, 9}, 2, 8)
        );
    }

    private void test(int[] prices, int fee, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.maxProfit(prices, fee);

        // then
        assertEquals(expected, actual);
    }

}
