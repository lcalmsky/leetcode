package io.lcalmsky.leetcode.backspace_string_compare;

public class Solution {
    public boolean backspaceCompare(String S, String T) {
        return remove(S).equals(remove(T));
    }

    private String remove(String origin) {
        StringBuilder sb = new StringBuilder(origin);
        while (true) {
            int index = sb.indexOf("#");
            if (index == -1) break;
            sb.deleteCharAt(index);
            if (index > 0) sb.deleteCharAt(index - 1);
        }
        return sb.toString();
    }
}
