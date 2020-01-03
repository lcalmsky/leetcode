package io.lcalmsky.leetcode.pascals_triangle_ii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) return Collections.singletonList(1);

        int[][] arr = new int[rowIndex + 1][rowIndex + 1];
        for (int i = 0; i <= rowIndex; i++) {
            arr[i][0] = 1;
            arr[0][i] = 1;
        }

        for (int i = 1; i <= rowIndex; i++) {
            for (int j = 1; j <= rowIndex; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }

        List<Integer> row = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) row.add(arr[rowIndex - i][i]);

        return row;
    }
}
