package io.lcalmsky.leetcode.binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenSortedArray_whenFindNumber_thenReturnsItsIndexCorrectly() {
        assertAll(
                () -> test(new int[]{-1, 0, 3, 5, 9, 12}, 9, 4),
                () -> test(new int[]{-1, 0, 3, 5, 9, 12}, 2, -1)
        );
    }

    private void test(int[] given, int target, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.search(given, target);

        // then
        assertEquals(expected, actual);
    }
}
