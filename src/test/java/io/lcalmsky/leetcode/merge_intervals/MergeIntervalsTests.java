package io.lcalmsky.leetcode.merge_intervals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeIntervalsTests {
    @Test
    public void givenTwoDimensionArray_whenMergeIntervals_thenCorrect() {
        assertAll(
                () -> test(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}, new int[][]{{1, 6}, {8, 10}, {15, 18}}),
                () -> test(new int[][]{{1, 4}, {4, 5}}, new int[][]{{1, 5}}),
                () -> test(new int[][]{}, new int[][]{})
        );
    }

    public void test(int[][] given, int[][] expected) {
        // when
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] result = mergeIntervals.merge(given);

        System.out.println(Arrays.deepToString(result));

        // then
        assertArrayEquals(expected, result);
    }
}
