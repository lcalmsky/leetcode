package io.lcalmsky.leetcode.coin_change_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinChange2Tests {
    @Test
    public void givenCoins_whenComputeTheNumberOfCombinations_thenCorrect() {
        assertAll(
                () -> test(5, new int[]{1, 2, 5}, 4),
                () -> test(3, new int[]{2}, 0),
                () -> test(10, new int[]{10}, 1)
        );
    }

    private void test(int amount, int[] coins, int expected) {
        // when
        CoinChange2 coinChange2 = new CoinChange2();
        int actual = coinChange2.change(amount, coins);

        // then
        assertEquals(expected, actual);
    }
}
