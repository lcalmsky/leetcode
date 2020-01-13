package io.lcalmsky.leetcode.find_minimum_in_rotated_sorted_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindMinimumInRotatedSortedArrayTests {
    @Test
    public void givenArray_whenFindMinimum_thenCorrect() {
        assertAll(
                () -> test(new int[]{3, 4, 5, 1, 2}, 1),
                () -> test(new int[]{4, 5, 6, 7, 0, 1, 2}, 0),
                () -> test(new int[]{3, 1, 2}, 1)
        );
    }

    private void test(int[] given, int expected) {
        // when
        FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray = new FindMinimumInRotatedSortedArray();
        int actual = findMinimumInRotatedSortedArray.findMin(given);

        // then
        assertEquals(expected, actual);
    }
}
