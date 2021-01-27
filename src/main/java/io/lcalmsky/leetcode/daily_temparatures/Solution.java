package io.lcalmsky.leetcode.daily_temparatures;

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        if (T.length == 0) return result;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; ++i) {
            while (!stack.empty() && T[i] > T[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            result[stack.pop()] = 0;
        }
        return result;
    }
}
