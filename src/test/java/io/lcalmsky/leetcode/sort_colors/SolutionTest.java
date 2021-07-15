package io.lcalmsky.leetcode.sort_colors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    private Solution solution;

    @Test
    void testAll() {
        assertAll(
//                () -> test(new int[]{2, 0, 2, 1, 1, 0}, new int[]{0, 0, 1, 1, 2, 2}),
                () -> test(new int[]{2, 0, 1}, new int[]{0, 1, 2})
//                () -> test(new int[]{0}, new int[]{0}),
//                () -> test(new int[]{1}, new int[]{1})
        );
    }

    private void test(int[] given, int[] expected) {
        // when
        solution = new Solution();
        solution.sortColors(given);

        // then
        assertArrayEquals(expected, given);
    }
}