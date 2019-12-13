package io.lcalmsky.leetcode.generate_parentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesesTests {
    public static void main(String[] args) {
        GenerateParenthesesTests generateParenthesesTests = new GenerateParenthesesTests();
        System.out.println(generateParenthesesTests.generateParenthesis(1));
        System.out.println(generateParenthesesTests.generateParenthesis(2));
        System.out.println(generateParenthesesTests.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, "", n, n);
        return result;
    }

    private void dfs(List<String> result, String s, int left, int right) {
        if (left > right) return;
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }
        if (left > 0) dfs(result, s + "(", left - 1, right);
        if (right > 0) dfs(result, s + ")", left, right - 1);
    }
}
