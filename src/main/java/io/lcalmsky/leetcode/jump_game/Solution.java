package io.lcalmsky.leetcode.jump_game;

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (max <= i && nums[i] == 0) {
                return false;
            }
            if (i + nums[i] > max) {
                max = i + nums[i];
            }
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}

class AnotherSolution extends Solution {
    @Override
    public boolean canJump(int[] nums) {
        int distance = 0;
        for (int i = 0; i <= distance; i++) {
            distance = Math.max(distance, i + nums[i]);
            if (distance >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}