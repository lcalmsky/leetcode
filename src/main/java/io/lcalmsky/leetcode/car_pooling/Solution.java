package io.lcalmsky.leetcode.car_pooling;

import java.util.Arrays;

public class Solution {

  public boolean carPooling(int[][] trips, int capacity) {
    Arrays.sort(trips, (o1, o2) -> o1[1] != o2[1] ? o1[1] - o2[1] : o2[2] - o1[2]);
    for (int i = 0; i < trips.length; i++) {
      int current = trips[i][0];
      for (int j = i - 1; j >= 0; j--) {
        if (trips[j][2] > trips[i][1]) {
          current += trips[j][0];
        }
      }
      if (current > capacity) {
        return false;
      }
    }
    return true;
  }
}

class AnotherSolution {
  public boolean carPooling(int[][] trips, int capacity) {
    int last = 0;
    int[] arr = new int[1001];
    for (int[] trip : trips) {
      int from = trip[1];
      int to = trip[2];
      int passengers = trip[0];
      arr[from] += passengers;
      arr[to] -= passengers;
      last = Math.max(last, to);
    }
    int passengers = 0;
    for (int i = 0; i < last; i++) {
      passengers += arr[i];
      if (passengers > capacity) {
        return false;
      }
    }
    return true;
  }
}