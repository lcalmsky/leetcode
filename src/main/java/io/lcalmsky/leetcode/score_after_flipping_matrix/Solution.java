package io.lcalmsky.leetcode.score_after_flipping_matrix;

public class Solution {
    public int matrixScore(int[][] A) {
        int rows = A.length, cols = A[0].length, result = (1 << (cols - 1)) * rows;
        for (int i = 1; i < cols; ++i) {
            int cnt = 0;
            for (int[] row : A) if (row[i] == row[0]) cnt++;
            result += Math.max(cnt, rows - cnt) * (1 << (cols - 1 - i));
        }
        return result;
    }
}
