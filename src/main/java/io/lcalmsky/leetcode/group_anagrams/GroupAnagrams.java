package io.lcalmsky.leetcode.group_anagrams;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> listMap = new LinkedHashMap<>();
        char[] charArray;
        List<String> list;
        String s;
        for (String str : strs) {
            charArray = str.toCharArray();
            Arrays.sort(charArray);
            s = new String(charArray);
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
