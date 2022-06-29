package io.lcalmsky.leetcode.queue_reconstruction_by_height;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public int[][] reconstructQueue(int[][] people) {
    int[][] result = new int[people.length][];
    Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
    List<int[]> list = new ArrayList<>();
    for (int[] array : people) {
      list.add(array[1], array);
    }
    for (int i = 0; i < people.length; i++) {
      result[i] = list.get(i);
    }
    return result;
  }
}
