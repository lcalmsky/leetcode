package io.lcalmsky.leetcode.unique_number_of_ocurrences;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{1, 2, 2, 1, 1, 3}, true),
                () -> test(new int[]{1, 2}, false),
                () -> test(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}, true)
        );
    }

    private void test(int[] arr, boolean expected) {
        // when
        Solution solution = new Solution();
        boolean actual = solution.uniqueOccurrences(arr);
        // then
        assertEquals(expected, actual);
    }
}