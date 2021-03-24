package io.lcalmsky.leetcode.rectangle_area_ii;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static final int LEFT = 0;
    public static final int TOP = 1;
    public static final int RIGHT = 2;
    public static final int BOTTOM = 3;
    private static final int MODULO = 1000000000 + 7;

    public int rectangleArea(int[][] rectangles) {
        long result = 0;
        List<int[]> all = new ArrayList<>();
        for (int[] rectangle : rectangles) helper(all, rectangle, 0);
        for (int[] subRectangle : all)
            result = (result + (long) (subRectangle[RIGHT] - subRectangle[LEFT]) * (long) (subRectangle[BOTTOM] - subRectangle[TOP])) % MODULO;
        return (int) result;
    }

    private void helper(List<int[]> all, int[] current, int start) {
        if (start >= all.size()) {
            all.add(current);
            return;
        }
        int[] rectangle = all.get(start);
        if (current[RIGHT] <= rectangle[LEFT] || current[BOTTOM] <= rectangle[TOP] || current[LEFT] >= rectangle[RIGHT] || current[TOP] >= rectangle[BOTTOM]) {
            helper(all, current, start + 1);
            return;
        }
        if (current[LEFT] < rectangle[LEFT])
            helper(all, new int[]{current[LEFT], current[TOP], rectangle[LEFT], current[BOTTOM]}, start + 1);
        if (current[RIGHT] > rectangle[RIGHT])
            helper(all, new int[]{rectangle[RIGHT], current[TOP], current[RIGHT], current[BOTTOM]}, start + 1);
        if (current[TOP] < rectangle[TOP])
            helper(all, new int[]{Math.max(rectangle[LEFT], current[LEFT]), current[TOP], Math.min(rectangle[RIGHT], current[RIGHT]), rectangle[TOP]}, start + 1);
        if (current[BOTTOM] > rectangle[BOTTOM])
            helper(all, new int[]{Math.max(rectangle[LEFT], current[LEFT]), rectangle[BOTTOM], Math.min(rectangle[RIGHT], current[RIGHT]), current[BOTTOM]}, start + 1);
    }
}
