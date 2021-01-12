package io.lcalmsky.leetcode.search_a_2d_matrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;

        if (target < matrix[0][0] || matrix[matrix.length - 1][matrix[matrix.length - 1].length - 1] < target)
            return false;

        int[] array;
        for (int[] ints : matrix) {
            array = ints;
            if (array[0] <= target && array[array.length - 1] >= target) {
                for (int value : array) if (value == target) return true;
                return false;
            }
        }
        return false;
    }
}
