package io.lcalmsky.leetcode.set_matrix_zeroes;

import java.util.Arrays;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int[][] copy = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < copy.length; i++) {
            System.arraycopy(matrix[i], 0, copy[i], 0, copy[i].length);
        }

        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[i].length; j++) {
                if (copy[i][j] != 0) continue;
                setZeroes(matrix, i, j);
            }
        }
    }

    private void setZeroes(int[][] matrix, int m, int n) {
        Arrays.fill(matrix[m], 0);
        for (int i = 0; i < matrix.length; i++) matrix[i][n] = 0;
    }
}