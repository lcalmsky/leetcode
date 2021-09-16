package io.lcalmsky.leetcode.longest_turbulent_subarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenNumbers_whenFindLongestTurbulentSubarray_thenCorrect() {
        assertAll(
                () -> test(new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9}, 5),
                () -> test(new int[]{4, 8, 12, 16}, 2),
                () -> test(new int[]{100}, 1)
        );
    }

    private void test(int[] given, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.maxTurbulenceSize(given);

        // then
        assertEquals(expected, actual);
    }
}