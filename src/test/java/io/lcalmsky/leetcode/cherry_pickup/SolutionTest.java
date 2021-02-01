package io.lcalmsky.leetcode.cherry_pickup;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenGrid_whenCollectCherries_thenReturnsMaximumNumberOfCherries() {
        assertAll(
                () -> test(new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 1, 1}}, 5),
                () -> test(new int[][]{{1, 1, -1}, {1, -1, 1}, {-1, 1, 1}}, 0)
        );
    }

    private void test(int[][] given, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.cherryPickup(given);

        // then
        assertEquals(expected, actual);
    }
}
