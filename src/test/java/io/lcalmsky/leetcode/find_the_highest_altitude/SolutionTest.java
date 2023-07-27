package io.lcalmsky.leetcode.find_the_highest_altitude;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{-5, 1, 5, 0, -7}, 1),
                () -> test(new int[]{-4, -3, -2, -1, 4, 3, 2}, 0)
        );
    }

    private void test(int[] gain, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.largestAltitude(gain);
        // then
        assertEquals(expected, actual);
    }

}