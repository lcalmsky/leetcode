package io.lcalmsky.leetcode.search_a_2d_matrix;

public class Solution {

  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    for (int[] row : matrix) {
      if (target <= row[n - 1]) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
          int mid = low + (high - low) / 2;
          if (target == row[mid]) {
            return true;
          }
          if (target < row[mid]) {
            high = mid - 1;
          } else {
            low = mid + 1;
          }
        }
      }
    }
    return false;
  }
}
