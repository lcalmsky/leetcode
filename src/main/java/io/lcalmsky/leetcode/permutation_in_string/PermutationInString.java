package io.lcalmsky.leetcode.permutation_in_string;

import java.util.Arrays;

/**
 * <pre>
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 *
 * Example 1:
 *
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 *
 *
 * Constraints:
 *
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 * </pre>
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] target = new int[26], current = new int[26];
        int count = s1.length(), begin = 0, end = 0;
        for (char c : s1.toCharArray()) target[c - 'a']++;
        while (end < s2.length()) {
            char c = s2.charAt(end++);
            if (target[c - 'a'] == 0) {
                begin = end;
                Arrays.fill(current, 0);
                count = s1.length();
            } else {
                current[c - 'a']++;
                count--;
                while (current[c - 'a'] > target[c - 'a']) {
                    current[s2.charAt(begin++) - 'a']--;
                    count++;
                }
                if (count == 0) return true;
            }
        }
        return false;
    }
}
