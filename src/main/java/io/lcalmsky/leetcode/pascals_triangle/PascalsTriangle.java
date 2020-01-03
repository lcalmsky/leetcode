package io.lcalmsky.leetcode.pascals_triangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return Collections.emptyList();

        int[][] arr = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            arr[i][0] = 1;
            arr[0][i] = 1;
        }

        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < numRows; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }

        List<List<Integer>> rows = new ArrayList<>();
        List<Integer> row;

        for (int i = 0; i < numRows; i++) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                row.add(arr[i - j][j]);
            }
            rows.add(row);
        }

        return rows;
    }
}
