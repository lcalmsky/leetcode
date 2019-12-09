package io.lcalmsky.leetcode.longest_valid_parentheses;

import java.util.Stack;

public class LongestValidParenthesesTests {
    public static void main(String[] args) {
        LongestValidParenthesesTests longestValidParenthesesTests = new LongestValidParenthesesTests();
        System.out.println(longestValidParenthesesTests.longestValidParentheses("(()"));
        System.out.println(longestValidParenthesesTests.longestValidParentheses(")()())"));
    }

    public int longestValidParentheses(String s) {
        Stack<int[]> stack = new Stack<>();
        int result = 0;

        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == ')') {
                if (!stack.isEmpty() && stack.peek()[0] == 0) {
                    stack.pop();
                    result = Math.max(result, i - (stack.isEmpty() ? -1 : stack.peek()[1]));
                } else {
                    stack.push(new int[]{1, i});
                }
            } else {
                stack.push(new int[]{0, i});
            }
        }
        return result;
    }
}
