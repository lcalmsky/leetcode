package io.lcalmsky.leetcode.find_minimum_in_rotated_sorted_array_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindMinimumInRotatedSortedArray2Tests {
    @Test
    public void givenRotatedSortedWithDuplicatesArray_whenFindMinimum_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 3, 5}, 1),
                () -> test(new int[]{2, 2, 2, 0, 1}, 0)
        );
    }

    private void test(int[] given, int expected) {
        // when
        Solution findMinimumInRotatedSortedArray2 = new Solution();
        int actual = findMinimumInRotatedSortedArray2.findMin(given);

        // then
        assertEquals(expected, actual);
    }
}
