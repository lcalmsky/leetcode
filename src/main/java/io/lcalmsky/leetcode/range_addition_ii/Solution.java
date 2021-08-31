package io.lcalmsky.leetcode.range_addition_ii;

public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int leftMin = m, rightMin = n;
        for (int[] op : ops) {
            leftMin = Math.min(op[0], leftMin);
            rightMin = Math.min(op[1], rightMin);
        }
        return leftMin * rightMin;
    }
}
