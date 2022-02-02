package io.lcalmsky.leetcode.find_all_anagram_in_a_string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

  public List<Integer> findAnagrams(String s, String p) {
    if (s == null) {
      return Collections.emptyList();
    }
    int sLength = s.length();
    int pLength = p.length();
    if (sLength == 0 || sLength < pLength) {
      return Collections.emptyList();
    }
    List<Integer> result = new ArrayList<>();
    int[] pMap = new int[26];
    int[] sMap = new int[26];
    for (int i = 0; i < pLength; i++) {
      pMap[p.charAt(i) - 'a']++;
    }
    for (int i = 0; i < pLength; i++) {
      sMap[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < sLength - pLength; i++) {
      if (isMatch(pMap, sMap)) {
        result.add(i);
      }
      sMap[s.charAt(i + pLength) - 'a']++;
      sMap[s.charAt(i) - 'a']--;
    }
    if (isMatch(pMap, sMap)) {
      result.add(sLength - pLength);
    }
    return result;
  }

  public boolean isMatch(int[] arr1, int[] arr2) {
    for (int i = 0; i < arr1.length; i++) {
      if (arr1[i] != arr2[i]) {
        return false;
      }
    }
    return true;
  }
}
