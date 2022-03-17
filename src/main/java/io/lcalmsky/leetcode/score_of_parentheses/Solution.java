package io.lcalmsky.leetcode.score_of_parentheses;

import java.util.Stack;

public class Solution {

  public int scoreOfParentheses(String s) {
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(0);
      } else {
        int x = stack.pop();
        int y = stack.pop();
        stack.push(y + Math.max(2 * x, 1));
      }
    }
    return stack.pop();
  }
}

class AnotherSolution {

  public int scoreOfParentheses(String s) {
    int score = 0;
    int depth = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        depth++;
      } else {
        depth--;
      }
      if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
        score += Math.pow(2, depth);
      }
    }
    return score;
  }
}
