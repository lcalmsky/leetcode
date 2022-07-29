package io.lcalmsky.leetcode.find_and_replace_pattern;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public static List<String> findAndReplacePattern(String[] words, String pattern) {
    List<String> list = new ArrayList<>();
    for (String word : words) {
      if (matches(word, pattern)) {
        list.add(word);
      }
    }
    return list;
  }

  private static boolean matches(String word, String pattern) {
    for (int i = 0; i < word.length(); i++) {
      if (word.indexOf(word.charAt(i)) != pattern.indexOf(pattern.charAt(i))) {
        return false;
      }
    }
    return true;
  }
}
