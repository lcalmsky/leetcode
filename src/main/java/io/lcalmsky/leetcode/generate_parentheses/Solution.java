package io.lcalmsky.leetcode.generate_parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", n, n);
        return result;
    }

    private void backtrack(List<String> result, String s, int left, int right) {
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }
        if (left > 0) {
            backtrack(result, s + "(", left - 1, right);
        }
        if (right > 0) {
            backtrack(result, s + ")", left, right - 1);
        }
    }
}
