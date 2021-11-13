package io.lcalmsky.leetcode.daily_temparatures;

import java.util.Stack;

/**
 * Runtime: 32 ms, faster than 73.20% of Java online submissions for Daily Temperatures.
 * Memory Usage: 48.7 MB, less than 68.59% of Java online submissions for Daily Temperatures.
 */
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        if (temperatures.length == 0) return result;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; ++i) {
            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}

/**
 * Runtime: 7 ms, faster than 97.35% of Java online submissions for Daily Temperatures.
 * Memory Usage: 54.2 MB, less than 38.05% of Java online submissions for Daily Temperatures.
 */
class Solution2 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        int[] stack = new int[temperatures.length];
        int top = -1;
        for(int i = 0; i < temperatures.length; i++) {
            while(top > -1 && temperatures[i] > temperatures[stack[top]]) {
                int idx = stack[top--];
                result[idx] = i - idx;
            }
            stack[++top] = i;
        }
        return result;
    }
}