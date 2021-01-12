package io.lcalmsky.leetcode.diagonal_traverse;

/**
 * <pre>
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
 *
 * Example:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * Output:  [1,2,4,7,5,3,6,8,9]
 *
 * Explanation:
 *
 * Note:
 *
 * The total number of elements of the given matrix will not exceed 10,000.
 * </pre>
 */
public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[]{};
        int row = matrix.length;
        int col = matrix[0].length;
        int[] diagonal = new int[row * col];

        for (int i = 0, x = 0, y = 0; i < row * col; i++) {
            diagonal[i] = matrix[x][y];
            if ((x + y) % 2 == 0) {
                if (y == col - 1) x++;
                else if (x == 0) y++;
                else {
                    x--;
                    y++;
                }
            } else {
                if (x == row - 1) y++;
                else if (y == 0) x++;
                else {
                    x++;
                    y--;
                }
            }
        }
        return diagonal;
    }
}
