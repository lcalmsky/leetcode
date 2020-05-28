package io.lcalmsky.leetcode.non_overlapping_internvals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NonOverlappingIntervalsTests {
    @Test
    public void givenIntervals_whenEraseOverlappedInterval_thenCorrect() {
        assertAll(
                () -> test(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}, 1),
                () -> test(new int[][]{{1, 2}, {1, 2}, {1, 2}}, 2),
                () -> test(new int[][]{{1, 2}, {2, 3}}, 0)
        );
    }

    private void test(int[][] given, int expected) {
        // when
        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();
        int actual = nonOverlappingIntervals.eraseOverlapIntervals(given);

        // then
        assertEquals(expected, actual);
    }
}
