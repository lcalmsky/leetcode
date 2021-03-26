package io.lcalmsky.leetcode.score_of_parentheses;

import java.util.Stack;

public class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> parentheses = new Stack<>();
        int multiplier = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                parentheses.push(multiplier);
                multiplier = 0;
            } else {
                multiplier = parentheses.pop() + Math.max(2 * multiplier, 1);
            }
        }
        return multiplier;
    }
}
