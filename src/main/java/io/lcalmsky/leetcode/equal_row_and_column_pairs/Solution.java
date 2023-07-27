package io.lcalmsky.leetcode.equal_row_and_column_pairs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> map = new HashMap<>();
        for (int[] row : grid) {
            String rowString = Arrays.toString(row);
            map.merge(rowString, 1, Integer::sum);
        }
        int pairs = 0;
        for (int i = 0; i < n; i++) {
            int[] col = new int[n];
            for (int j = 0; j < n; j++) {
                col[j] = grid[j][i];
            }
            String colString = Arrays.toString(col);
            pairs += map.getOrDefault(colString, 0);
        }
        return pairs;
    }
}
