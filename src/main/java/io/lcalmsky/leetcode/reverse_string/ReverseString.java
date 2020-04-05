package io.lcalmsky.leetcode.reverse_string;

public class ReverseString {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;

        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
