package io.lcalmsky.leetcode.remove_covered_intervals;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

  public int removeCoveredIntervals(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    int[] currentIndices = { -1, -1 };
    int result = 0;
    for (int[] interval : intervals) {
      if (currentIndices[0] < interval[0] && currentIndices[1] < interval[1]) {
        currentIndices[0] = interval[0];
        result++;
      }
      currentIndices[1] = Math.max(currentIndices[1], interval[1]);
    }
    return result;
  }
}
