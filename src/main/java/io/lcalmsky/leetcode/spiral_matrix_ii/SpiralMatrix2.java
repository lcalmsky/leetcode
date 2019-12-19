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

//    public int[][] generateMatrix2(int n) {
//        int total = n * n;
//        int[][] result = new int[n][n];
//
//        int x = 0;
//        int y = 0;
//        int step = 0;
//
//        for (int i = 0; i < total; ) {
//            while (y + step < n) {
//                i++;
//                result[x][y] = i;
//                y++;
//
//            }
//            y--;
//            x++;
//
//            while (x + step < n) {
//                i++;
//                result[x][y] = i;
//                x++;
//            }
//            x--;
//            y--;
//
//            while (y >= step) {
//                i++;
//                result[x][y] = i;
//                y--;
//            }
//            y++;
//            x--;
//            step++;
//
//            while (x >= step) {
//                i++;
//                result[x][y] = i;
//                x--;
//            }
//            x++;
//            y++;
//        }
//
//        return result;
//    }
}
