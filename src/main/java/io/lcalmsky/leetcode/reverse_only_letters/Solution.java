package io.lcalmsky.leetcode.reverse_only_letters;

import java.util.Stack;

public class Solution {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (Character.isAlphabetic(chars[left]) && Character.isAlphabetic(chars[right])) {
                char temp = chars[right];
                chars[right] = chars[left];
                chars[left] = temp;
                left++;
                right--;
            } else if (Character.isAlphabetic(chars[left])) {
                right--;
            } else if (Character.isAlphabetic(chars[right])) {
                left++;
            } else {
                left++;
                right--;
            }
        }
        return String.valueOf(chars);
    }
}

class AnotherSolution extends Solution {
    @Override
    public String reverseOnlyLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                stack.push(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                stringBuilder.append(stack.pop());
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}

class AnotherSolution2 extends Solution {
    @Override
    public String reverseOnlyLetters(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int start = 0, end = s.length() - 1; start < end; ++start, --end) {
            while (start < end && !Character.isLetter(sb.charAt(start))) ++start;
            while (start < end && !Character.isLetter(sb.charAt(end))) --end;
            sb.setCharAt(start, s.charAt(end));
            sb.setCharAt(end, s.charAt(start));
        }
        return sb.toString();
    }
}
