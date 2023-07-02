package io.lcalmsky.leetcode.group_anagrams;

import java.util.*;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = new char[26];
            char[] charArray = str.toCharArray();
            for (char c : charArray) {
                array[c - 'a']++;
            }
            String newStr = new String(array);
            if (!map.containsKey(newStr)) {
                map.put(newStr, new ArrayList<>());
            }
            map.get(newStr).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
