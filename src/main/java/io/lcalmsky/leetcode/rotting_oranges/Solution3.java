package io.lcalmsky.leetcode.rotting_oranges;

public class Solution3 {
    public int orangesRotting(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    rotAdjacent(grid, i, j, 2);
                }
            }
        }
        int minutes = 2;
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) {
                    return -1;
                }
                minutes = Math.max(minutes, cell);
            }
        }
        return minutes;
    }

    private void rotAdjacent(int[][] grid, int x, int y, int minutes) {
        if (x < 0 || x >= grid.length
                || y < 0 || y >= grid[0].length
                || grid[x][y] == 0
                || (1 < grid[x][y] && grid[x][y] > minutes)) {
            return;
        }
        grid[x][y] = minutes;
        rotAdjacent(grid, x + 1, y, minutes + 1);
        rotAdjacent(grid, x - 1, y, minutes + 1);
        rotAdjacent(grid, x, y + 1, minutes + 1);
        rotAdjacent(grid, x, y - 1, minutes + 1);
    }
}