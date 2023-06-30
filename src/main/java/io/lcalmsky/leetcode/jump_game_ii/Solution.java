package io.lcalmsky.leetcode.jump_game_ii;

public class Solution {

    public int jump(int[] nums) {
        int lastReach = 0;
        int reach = 0;
        int step = 0;
        for (int i = 0; i <= reach && i < nums.length; i++) {
            if (i > lastReach) {
                step++;
                lastReach = reach;
            }
            reach = Math.max(reach, nums[i] + i);
        }
        return step;
    }
}
