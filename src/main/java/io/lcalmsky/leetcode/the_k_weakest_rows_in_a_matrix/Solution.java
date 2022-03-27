package io.lcalmsky.leetcode.the_k_weakest_rows_in_a_matrix;

public class Solution {

  public int[] kWeakestRows(int[][] mat, int k) {
    int[] soldiers = new int[mat.length];
    int[] result = new int[k];
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        if (mat[i][j] == 1) {
          soldiers[i]++;
        }
      }
    }
    int index = 0;
    while (k > 0) {
      int minIndex = 0;
      for (int i = 0; i < soldiers.length; i++) {
        if (soldiers[i] < soldiers[minIndex]) {
          minIndex = i;
        }
      }
      result[index++] = minIndex;
      soldiers[minIndex] = Integer.MAX_VALUE;
      k--;
    }
    return result;
  }
}
