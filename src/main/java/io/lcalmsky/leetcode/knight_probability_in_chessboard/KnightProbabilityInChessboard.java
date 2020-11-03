package io.lcalmsky.leetcode.knight_probability_in_chessboard;

import java.util.Arrays;

/**
 * <pre>
 * On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves. The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).
 *
 * A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
 *
 * Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.
 *
 * The knight continues moving until it has made exactly K moves or has moved off the chessboard. Return the probability that the knight remains on the board after it has stopped moving.
 *
 * Example:
 *
 * Input: 3, 2, 0, 0
 * Output: 0.0625
 * Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
 * From each of those positions, there are also two moves that will keep the knight on the board.
 * The total probability the knight stays on the board is 0.0625.
 *
 * Note:
 * N will be between 1 and 25.
 * K will be between 0 and 100.
 * The knight always initially starts on the board.
 * </pre>
 */
public class KnightProbabilityInChessboard {
    private static final int[][] DIRECTIONS = new int[][]{{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};

    public double knightProbability(int N, int K, int r, int c) {
        double[][] dp = new double[N][N];
        for (double[] row : dp) Arrays.fill(row, 1);
        for (int k = 0; k < K; k++) {
            double[][] temp = new double[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] direction : DIRECTIONS) {
                        int row = i + direction[0];
                        int col = j + direction[1];
                        if (isOnBoard(row, col, N)) {
                            temp[i][j] += dp[row][col];
                        }
                    }
                }
            }
            dp = temp;
        }
        return dp[r][c] / Math.pow(8, K);
    }

    private boolean isOnBoard(int row, int col, int N) {
        return row >= 0 && row < N && col >= 0 && col < N;
    }
}
