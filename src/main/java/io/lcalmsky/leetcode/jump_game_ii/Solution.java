package io.lcalmsky.leetcode.jump_game_ii;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{2, 3, 1, 1, 4}));
    }

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int lastReach = 0;
        int reach = 0;
        int step = 0;

        for (int i = 0; i <= reach && i < nums.length; i++) {
            //when last jump can not read current i, increase the step by 1
            if (i > lastReach) {
                step++;
                lastReach = reach;
            }
            //update the maximal jump
            reach = Math.max(reach, nums[i] + i);
        }

        if (reach < nums.length - 1)
            return 0;

        return step;
    }
}
