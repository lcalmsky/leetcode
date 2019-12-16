package io.lcalmsky.leetcode.group_anagrams;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> listMap = new LinkedHashMap<>();
        char[] charArray, arr;
        List<String> list;
        String s;
        for (String str : strs) {
            arr = new char[26];
            charArray = str.toCharArray();
            for (char c : charArray) {
                arr[c - 'a']++;
            }
            s = new String(arr);
            if (!listMap.containsKey(s)) {
                list = new ArrayList<>();
                list.add(str);
                listMap.put(s, list);
            } else {
                listMap.get(s).add(str);
            }
        }

        return new ArrayList<>(listMap.values());
    }
}
