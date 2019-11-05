package io.lcalmsky.leetcode.logest_substring_without_repeating_characters;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        char[] charArray = s.toCharArray();
        int max = 0, start = 0, end = 0;
        while (start < s.length() && end < s.length()) {
            if (seen.contains(charArray[end])) seen.remove(charArray[start++]);
            else {
                seen.add(charArray[end++]);
                max = Math.max(max, end - start);
            }
        }
        return max;
    }
}
