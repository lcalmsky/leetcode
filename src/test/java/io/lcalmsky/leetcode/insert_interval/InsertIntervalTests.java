package io.lcalmsky.leetcode.insert_interval;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class InsertIntervalTests {
    @Test
    public void givenTwoDimensionArray_whenInsertInterval_thenCorrect() {
        assertAll(
                () -> test(
                        new int[][]{{1, 3}, {6, 9}},
                        new int[]{2, 5},
                        new int[][]{{1, 5}, {6, 9}})
                ,
                () -> test(
                        new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
                        new int[]{4, 8},
                        new int[][]{{1, 2}, {3, 10}, {12, 16}})
        );
    }

    public void test(int[][] given, int[] interval, int[][] expected) {
        // when
        Solution insertInterval = new Solution();
        int[][] actual = insertInterval.insert(given, interval);

        // then
        assertArrayEquals(expected, actual);
    }
}
