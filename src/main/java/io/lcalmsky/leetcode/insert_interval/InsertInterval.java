package io.lcalmsky.leetcode.insert_interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0)
            return newInterval == null || newInterval.length == 0
                    ? new int[][]{}
                    : new int[][]{newInterval};

        int[][] array = new int[intervals.length + 1][2];
        System.arraycopy(intervals, 0, array, 0, intervals.length);
        array[intervals.length] = newInterval;

        Arrays.sort(array, Comparator.comparingInt(o -> o[0]));

        int[] interval = array[0];
        List<int[]> list = new ArrayList<>();
        for (int[] ints : array) {
            if (interval[1] >= ints[0]) {
                interval[1] = Math.max(interval[1], ints[1]);
            } else {
                list.add(interval);
                interval = ints;
            }
        }
        list.add(interval);

        int[][] result = new int[list.size()][2];
        IntStream.range(0, list.size()).forEach(i -> result[i] = list.get(i));

        return result;
    }
}
