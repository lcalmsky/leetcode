package io.lcalmsky.leetcode.spiral_matrix_ii;

public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int cnt = 1, left = 0, right = n - 1, top = 0, bottom = n - 1;

        while (cnt <= n * n) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = cnt++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = cnt++;
            }
            right--;

            if (bottom < top) break;

            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = cnt++;
            }
            bottom--;

            if (right < left) break;

            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = cnt++;
            }
            left++;
        }

        return matrix;
    }
}
