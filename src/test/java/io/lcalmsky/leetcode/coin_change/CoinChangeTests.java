package io.lcalmsky.leetcode.coin_change;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinChangeTests {
    @Test
    public void givenCoins_whenGetFewestNumberOfCoins_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 2, 5}, 11, 3),
                () -> test(new int[]{2}, 3, -1)
        );
    }

    private void test(int[] coins, int amount, int expected) {
        // when
        Solution coinChange = new Solution();
        int actual = coinChange.coinChange(coins, amount);

        // then
        assertEquals(expected, actual);
    }
}
