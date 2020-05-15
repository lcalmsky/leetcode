package io.lcalmsky.leetcode.longest_palindrome;

/**
 * <pre>
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 *
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * </pre>
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] lowercase = new int[26];
        int[] uppercase = new int[26];
        int result = 0;
        for (char c : s.toCharArray()) {
            if (c >= 97) lowercase[c - 'a']++;
            else uppercase[c - 'A']++;
        }
        for (int i = 0; i < 26; i++) {
            result += (lowercase[i] / 2) * 2;
            result += (uppercase[i] / 2) * 2;
        }
        return result == s.length() ? result : result + 1;
    }
}
