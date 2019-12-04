package io.lcalmsky.leetcode.valid_parentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesesTests {
    public static void main(String[] args) {
        ValidParenthesesTests validParenthesesTests = new ValidParenthesesTests();
        System.out.println(validParenthesesTests.isValid("()"));
        System.out.println(validParenthesesTests.isValid("()[]{}"));
        System.out.println(validParenthesesTests.isValid("(]"));
        System.out.println(validParenthesesTests.isValid("([)]"));
        System.out.println(validParenthesesTests.isValid("{[]}"));
    }

    public boolean isValid(String s) {
        if (s.isEmpty()) return true;
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<Character>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (stack.empty() || !(map.get(stack.pop()) == c)) {
                return false;
            }
        }

        return stack.empty();
    }
}
