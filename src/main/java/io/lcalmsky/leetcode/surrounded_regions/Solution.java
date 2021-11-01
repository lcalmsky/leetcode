package io.lcalmsky.leetcode.surrounded_regions;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
        {0, 0, 1, -1}, {1, -1, 0, 0}
    };


    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        checkFirstAndLastRows(board, m, n, queue);
        checkFirstAndLastColumns(board, m, n, queue);
        checkNeighbor(board, m, n, queue);
        updateBoard(board, m, n);
    }

    private void checkFirstAndLastRows(char[][] board, int m, int n, Queue<int[]> queue) {
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                board[0][i] = '*';
                queue.offer(new int[]{0, i});
            }
            if (board[m - 1][i] == 'O') {
                board[m - 1][i] = '*';
                queue.offer(new int[]{m - 1, i});
            }
        }
    }

    private void checkFirstAndLastColumns(char[][] board, int m, int n, Queue<int[]> queue) {
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = '*';
                queue.offer(new int[]{i, 0});
            }
            if (board[i][n - 1] == 'O') {
                board[i][n - 1] = '*';
                queue.offer(new int[]{i, n - 1});
            }
        }
    }

    private void checkNeighbor(char[][] board, int m, int n, Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = current[0] + DIRECTIONS[0][i];
                int y = current[1] + DIRECTIONS[1][i];
                if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
                    board[x][y] = '*';
                    queue.offer(new int[]{x, y});
                }
            }
        }
    }

    private void updateBoard(char[][] board, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
