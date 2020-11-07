package io.lcalmsky.leetcode.valid_palindrome_ii;

/**
 * <pre>
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * </pre>
 */
public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                int j = s.length() - 1 - i;
                return (isPalindromeWithRange(s, i + 1, j) ||
                        isPalindromeWithRange(s, i, j - 1));
            }
        }
        return true;
    }

    private boolean isPalindromeWithRange(String s, int i, int j) {
        for (int k = i; k <= i + (j - i) / 2; k++) {
            if (s.charAt(k) != s.charAt(j - k + i)) return false;
        }
        return true;
    }
}
