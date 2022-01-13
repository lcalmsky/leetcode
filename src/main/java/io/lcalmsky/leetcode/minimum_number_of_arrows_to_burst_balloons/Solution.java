package io.lcalmsky.leetcode.minimum_number_of_arrows_to_burst_balloons;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

  public int findMinArrowShots(int[][] points) {
    if (points == null || points.length == 0) {
      return 0;
    }
    Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
    int arrowPosition = points[0][1];
    int arrowCount = 1;
    for (int i = 1; i < points.length; i++) {
      if (points[i][0] <= arrowPosition) {
        continue;
      }
      arrowCount++;
      arrowPosition = points[i][1];
    }
    return arrowCount;
  }
}
