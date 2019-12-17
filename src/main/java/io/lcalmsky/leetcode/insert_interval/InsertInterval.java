package io.lcalmsky.leetcode.insert_interval;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                list.add(interval);
            } else if (interval[0] > newInterval[1]) {
                list.add(newInterval);
                newInterval = interval;
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }

        list.add(newInterval);

        int[][] result = new int[list.size()][2];
        IntStream.range(0, list.size()).forEach(i -> result[i] = list.get(i));

        return result;
    }
}
