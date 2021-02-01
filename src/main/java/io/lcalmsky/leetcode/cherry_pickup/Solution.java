package io.lcalmsky.leetcode.cherry_pickup;

public class Solution {
    int[][][] mem;

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        mem = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    mem[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        return Math.max(0, dfs(grid, n - 1, n - 1, n - 1));
    }

    private int dfs(int[][] grid, int x1, int y1, int x2) {
        int y2 = x1 + y1 - x2;
        if (x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0 || grid[x1][y1] == -1 || grid[x2][y2] == -1) return -1;
        if (x1 == 0 && y1 == 0) return grid[0][0];
        if (mem[x1][y1][x2] != Integer.MIN_VALUE) return mem[x1][y1][x2];

        int rst = Math.max(Math.max(dfs(grid, x1 - 1, y1, x2), dfs(grid, x1 - 1, y1, x2 - 1)),
                Math.max(dfs(grid, x1, y1 - 1, x2), dfs(grid, x1, y1 - 1, x2 - 1)));
        if (rst < 0) {
            mem[x1][y1][x2] = -1;
            return rst;
        }
        rst += grid[x1][y1];
        if (x1 != x2) rst += grid[x2][y2];
        mem[x1][y1][x2] = rst;
        return mem[x1][y1][x2];
    }
}
