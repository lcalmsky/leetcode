package io.lcalmsky.leetcode.shortest_path_in_binary_matrix;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  private final static int[][] DIRECTIONS = new int[][]{
      {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}
  };

  public int shortestPathBinaryMatrix(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
      return -1;
    }
    boolean[][] visited = new boolean[m][n];
    visited[0][0] = true;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0});
    int length = 1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] pop = queue.poll();
        if (pop[0] == m - 1 && pop[1] == n - 1) {
          return length;
        }
        for (int j = 0; j < 8; j++) {
          int nextX = DIRECTIONS[j][0] + pop[0];
          int nextY = DIRECTIONS[j][1] + pop[1];
          if (isInRange(m, n, nextX, nextY) && !visited[nextX][nextY] && grid[nextX][nextY] == 0) {
            queue.add(new int[]{nextX, nextY});
            visited[nextX][nextY] = true;
          }
        }
      }
      length++;
    }
    return -1;
  }

  private boolean isInRange(int m, int n, int nextX, int nextY) {
    return nextX >= 0 && nextX < m && nextY >= 0 && nextY < n;
  }
}
