package io.lcalmsky.leetcode.longest_palindromic_substring;

public class Solution {
    public static String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        if (s.length() == 2)
            if (s.charAt(0) == s.charAt(1)) return s;
            else return s.substring(0, 1);

        String palindrome = "";
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int start = length - 2; start > -1; start--) {
            for (int end = start; end < length; end++) {
                dp[start][end] = dp[start + 1][end - 1] && s.charAt(start) == s.charAt(end);
                if (dp[start][end] && palindrome.length() < end - start + 1)
                    palindrome = s.substring(start, end + 1);
            }
        }
        return palindrome;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aabbcdedaac"));
    }
}