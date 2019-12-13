package io.lcalmsky.leetcode.rotate_image;

import java.util.Arrays;

public class RotateImageTests {
    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix2 = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        RotateImageTests rotateImageTests = new RotateImageTests();
        rotateImageTests.rotate(matrix1);
        rotateImageTests.rotate(matrix2);

        Arrays.stream(matrix1).map(Arrays::toString).forEach(System.out::println);
        Arrays.stream(matrix2).map(Arrays::toString).forEach(System.out::println);
    }

    public void rotate(int[][] matrix) {
        int[][] copy = new int[matrix.length][matrix.length];
        for (int i = 0; i < copy.length; i++) {
            System.arraycopy(matrix[i], 0, copy[i], 0, copy.length);
        }
        int len = matrix.length - 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][len - i] = copy[i][j];
            }
        }
    }
}
