package io.lcalmsky.leetcode.rotting_oranges;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    private static final int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        Queue<Spot> rottingSpots = findRottingSpots(grid);
        int minutes = calculateRottingMinutes(grid, rottingSpots);
        if (hasNormalOrange(grid)) {
            return -1;
        }
        return minutes;
    }

    private Queue<Spot> findRottingSpots(int[][] grid) {
        Queue<Spot> rottingSpots = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    rottingSpots.add(Spot.of(i, j));
                }
            }
        }
        return rottingSpots;
    }

    private int calculateRottingMinutes(int[][] grid, Queue<Spot> rottingSpots) {
        int minutes = 0;
        while (!rottingSpots.isEmpty()) {
            int numberOfSpots = rottingSpots.size();
            boolean counted = false;
            for (int i = 0; i < numberOfSpots; i++) {
                Spot spot = rottingSpots.remove();
                for (int j = 0; j < 4; j++) {
                    int x = spot.x + DIRECTIONS[j][0];
                    int y = spot.y + DIRECTIONS[j][1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        if (!counted) {
                            minutes += 1;
                            counted = true;
                        }
                        rottingSpots.add(Spot.of(x, y));
                    }
                }

            }
        }
        return minutes;
    }

    private boolean hasNormalOrange(int[][] grid) {
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static final class Spot {
        private int x;
        private int y;

        private Spot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Spot of(int x, int y) {
            return new Spot(x, y);
        }
    }
}
