package io.lcalmsky.leetcode.search_a_2d_matrix_ii;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;

        int i = m, j = 0;
        while (i >= 0 && j <= n) {
            if (target < matrix[i][j]) {
                i--;
            } else if (target > matrix[i][j]) {
                j++;
            } else return true;
        }

        return false;
    }
}
