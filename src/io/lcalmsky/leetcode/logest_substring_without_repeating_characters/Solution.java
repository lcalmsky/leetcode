package io.lcalmsky.leetcode.logest_substring_without_repeating_characters;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int max = 0, start = 0, end = 0;
        while (start < s.length() && end < s.length()) {
            if (seen.contains(s.charAt(end))) seen.remove(s.charAt(start++));
            else {
                seen.add(s.charAt(end++));
                max = Math.max(max, end - start);
            }
        }
        return max;
    }
}
