package io.lcalmsky.leetcode.pascals_triangle_ii;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();

        long c = 1;
        for (int j = 0; j <= rowIndex; j++) {
            result.add((int) c);
            c *= rowIndex - j;
            c /= j + 1;
        }
        return result;
    }
}
