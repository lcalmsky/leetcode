package io.lcalmsky.leetcode.gas_station;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GasStationTests {
    @Test
    public void givenGasAndCostArrays_whenFindStartIndex_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}, 3),
                () -> test(new int[]{2, 3, 4}, new int[]{3, 4, 3}, -1)
        );
    }

    private void test(int[] gas, int[] cost, int expected) {
        // when
        GasStation gasStation = new GasStation();
        int actual = gasStation.canCompleteCircuit(gas, cost);

        // then
        assertEquals(expected, actual);
    }
}