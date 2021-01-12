package io.lcalmsky.leetcode.find_all_anagram_in_a_string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 * </pre>
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0 || s.length() < p.length()) return Collections.emptyList();

        List<Integer> result = new ArrayList<>();
        int[] pMap = new int[26];
        int[] sMap = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pMap[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i < p.length(); i++) {
            sMap[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length() - p.length(); i++) {
            if (isMatch(pMap, sMap)) {
                result.add(i);
            }
            // if don't match, we move the sliding window
            // remove the preceding character and add a new succeeding character to the new window
            sMap[s.charAt(i + p.length()) - 'a']++;
            sMap[s.charAt(i) - 'a']--;
        }
        if (isMatch(pMap, sMap)) {
            result.add(s.length() - p.length());
        }
        return result;
    }

    public boolean isMatch(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) if (arr1[i] != arr2[i]) return false;
        return true;
    }
}
