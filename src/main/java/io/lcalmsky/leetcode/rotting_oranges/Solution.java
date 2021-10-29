package io.lcalmsky.leetcode.rotting_oranges;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private static final int[][] directions = new int[][]{
        {1, -1, 0, 0},
        {0, 0, 1, -1}
    };

    public int orangesRotting(int[][] grid) {
        Queue<int[]> rottens = findRottenOranges(grid);
        int times = calculateRottingTimes(grid, rottens);
        if (!areAllRotten(grid)) {
            return -1;
        }
        return times;
    }

    private Queue<int[]> findRottenOranges(int[][] grid) {
        Queue<int[]> rottens = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rottens.add(new int[]{i, j});
                }
            }
        }
        return rottens;
    }

    private int calculateRottingTimes(int[][] grid, Queue<int[]> rottens) {
        int times = 0;
        while (!rottens.isEmpty()) {
            int size = rottens.size();
            boolean counted = false;
            for (int k = 0; k < size; k++) {
                int[] rotten = rottens.poll();
                for (int i = 0; i < 4; i++) {
                    int x = rotten[0] + directions[0][i];
                    int y = rotten[1] + directions[1][i];
                    if (x >= 0 && x < grid.length && y >= 0
                        && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        if (!counted) {
                            times++;
                            counted = true;
                        }
                        rottens.add(new int[]{x, y});
                    }
                }
            }
        }
        return times;
    }

    private boolean areAllRotten(int[][] grid) {
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
