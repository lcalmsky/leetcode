package io.lcalmsky.leetcode.isomorphic_strings;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map1.containsKey(c1)) {
                if (map1.get(c1) != c2) return false;
            } else {
                if (map2.containsKey(c2)) return false;
                map1.put(c1, c2);
                map2.put(c2, c1);
            }
        }

        return true;
    }
}
