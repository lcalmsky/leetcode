package io.lcalmsky.leetcode.bus_routes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenRoutesAndSourceAndTarget_whenTravel_thenReturnsLeastNumberOfBuses() {
        assertAll(
                () -> test(new int[][]{
                        {1, 2, 7},
                        {3, 6, 7}
                }, 1, 6, 2),
                () -> test(new int[][]{
                        {7, 12},
                        {4, 5, 16},
                        {6},
                        {15, 19},
                        {9, 12, 13}
                }, 15, 12, -1)
        );
    }

    private void test(int[][] routes, int source, int target, int expected) {
        // when
        Solution solution = new Solution();
        final int actual = solution.numBusesToDestination(routes, source, target);

        // then
        assertEquals(expected, actual);
    }

}