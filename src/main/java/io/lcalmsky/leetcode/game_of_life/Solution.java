package io.lcalmsky.leetcode.game_of_life;

public class Solution {

  private final static int LIVE = 2;
  private final static int DEAD = 3;
  private final static int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1},
      {1, -1}, {1, 1}, {-1, -1}, {-1, 1}};

  public void gameOfLife(int[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) {
      return;
    }
    int m = board.length;
    int n = board[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int count = 0;
        for (int[] dir : DIRECTIONS) {
          int row = i + dir[0];
          int col = j + dir[1];
          if (row < 0 || col < 0 || row >= m || col >= n) {
            continue;
          }
          if (board[row][col] == 1 || board[row][col] == DEAD) {
            count++;
          }
        }
        if (board[i][j] == 1 && (count < 2 || count > 3)) {
          board[i][j] = DEAD;
        } else if (board[i][j] == 0 && count == 3) {
          board[i][j] = LIVE;
        }
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == LIVE) {
          board[i][j] = 1;
        } else if (board[i][j] == DEAD) {
          board[i][j] = 0;
        }
      }
    }
  }
}
