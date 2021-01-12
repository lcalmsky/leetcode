package io.lcalmsky.leetcode.merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals.length == 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> list = new ArrayList<>();
        int[] interval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= interval[1]) {
                interval[1] = Math.max(intervals[i][1], interval[1]);
            } else {
                list.add(interval);
                interval = intervals[i];
            }
        }

        list.add(interval);

        int[][] result = new int[list.size()][2];
        IntStream.range(0, list.size()).forEach(i -> result[i] = list.get(i));

        return result;
    }
}
