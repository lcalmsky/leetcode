package io.lcalmsky.leetcode.search_in_rotated_sorted_array_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchInRotatedSortedArray2Tests {
    @Test
    public void givenRotatedSortedArray_whenSearch_thenCorrect() {
        assertAll(
                () -> test(new int[]{2, 5, 6, 0, 0, 1, 2}, 0, true),
                () -> test(new int[]{2, 5, 6, 0, 0, 1, 2}, 3, false)
        );
    }

    private void test(int[] givenArray, int givenTarget, boolean expected) {
        // when
        SearchInRotatedSortedArray2 searchInRotatedSortedArray2 = new SearchInRotatedSortedArray2();
        boolean actual = searchInRotatedSortedArray2.search(givenArray, givenTarget);

        // then
        assertEquals(expected, actual);
    }
}
