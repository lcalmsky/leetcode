package io.lcalmsky.leetcode.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            char key = s.charAt(end);
            if (map.containsKey(key)) {
                start = Math.max(start, map.get(key) + 1);
            }
            map.put(key, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
