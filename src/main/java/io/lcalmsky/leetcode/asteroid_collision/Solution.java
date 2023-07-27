package io.lcalmsky.leetcode.asteroid_collision;

import java.util.Stack;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0 || stack.isEmpty()) {
                stack.push(asteroid);
                continue;
            }
            int abs = Math.abs(asteroid);
            while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < abs) {
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() == abs) {
                stack.pop();
            } else if (stack.isEmpty() || stack.peek() < 0) {
                stack.push(asteroid);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
