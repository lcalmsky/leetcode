package io.lcalmsky.leetcode.delete_and_earn;

public class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) max = Math.max(max, num);
        int[] points = new int[max + 1];
        for (int num : nums) points[num] += num;
        return rob(points);
    }

    private int rob(int[] points) {
        long rob = 0, notRob = 0;
        for (int point : points) {
            long currRob = notRob + point;
            notRob = Math.max(notRob, rob);
            rob = currRob;
        }
        return (int) Math.max(rob, notRob);
    }
}
