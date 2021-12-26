package io.lcalmsky.leetcode.k_closest_points_to_origin;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

  public int[][] kClosest(int[][] points, int k) {
    int[][] result = new int[k][2];
    Arrays.sort(points, Comparator.comparingDouble(o -> Math.pow(o[0], 2) + Math.pow(o[1], 2)));
    System.arraycopy(points, 0, result, 0, result.length);
    return result;
  }
}