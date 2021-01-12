package io.lcalmsky.leetcode.palindrome_number;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(-121));
        System.out.println(solution.isPalindrome(10));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x / 10 == 0) return true;

        char[] s = String.valueOf(x).toCharArray();
        int len = s.length;
        int start = 0;
        int end = len - 1;
        for (int i = 0; i <= len / 2; i++) {
            if (s[start++] != s[end--]) return false;
        }
        return true;
    }
}
