package io.lcalmsky.leetcode.removing_stars_from_a_string;

import java.util.Stack;

public class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            Character pop = stack.pop();
            stringBuilder.append(pop);
        }
        return stringBuilder.reverse().toString();
    }
}
