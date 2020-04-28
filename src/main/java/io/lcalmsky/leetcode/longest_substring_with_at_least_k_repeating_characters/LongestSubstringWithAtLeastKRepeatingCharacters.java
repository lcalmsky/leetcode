package io.lcalmsky.leetcode.longest_substring_with_at_least_k_repeating_characters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
 *
 * Example 1:
 *
 * Input:
 * s = "aaabb", k = 3
 *
 * Output:
 * 3
 *
 * The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2:
 *
 * Input:
 * s = "ababbc", k = 2
 *
 * Output:
 * 5
 *
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 * </pre>
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        Set<Character> set = new HashSet<>();
        for (char c : counter.keySet()) {
            if (counter.get(c) < k) set.add(c);
        }

        if (set.isEmpty()) return s.length();

        int max = 0;
        int i = 0, j = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            if (set.contains(c)) {
                if (j != i) {
                    max = Math.max(max, longestSubstring(s.substring(i, j), k));
                }
                i = j + 1;
            }
            j++;
        }
        if (i != j) max = Math.max(max, longestSubstring(s.substring(i, j), k));

        return max;
    }
}
