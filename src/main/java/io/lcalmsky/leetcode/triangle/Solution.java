package io.lcalmsky.leetcode.triangle;

import java.util.List;

public class Solution {

  public int minimumTotal(List<List<Integer>> triangle) {
    int[] total = new int[triangle.size()];
    int height = triangle.size() - 1;
    for (int i = 0; i < triangle.get(height).size(); i++) {
      total[i] = triangle.get(height).get(i);
    }
    for (int i = triangle.size() - 2; i >= 0; i--) {
      for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
        total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);
      }
    }
    return total[0];
  }
}
