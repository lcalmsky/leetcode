package io.lcalmsky.leetcode.house_robber_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HouseRobber2Tests {
    @Test
    public void givenNumbers_whenRobHouses_thenGetMaximumMoney() {
        assertAll(
                () -> test(new int[]{2, 3, 2}, 3),
                () -> test(new int[]{1, 2, 3, 1}, 4)
        );
    }

    private void test(int[] given, int expected) {
        // when
        HouseRobber2 houseRobber2 = new HouseRobber2();
        int actual = houseRobber2.rob(given);

        // then
        assertEquals(expected, actual);
    }
}
