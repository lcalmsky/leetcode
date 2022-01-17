package io.lcalmsky.leetcode.word_pattern;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public boolean wordPattern(String pattern, String str) {
    char[] patterns = pattern.toCharArray();
    String[] words = str.split(" ");
    if (patterns.length != words.length) {
      return false;
    }
    Map<Character, String> patternMap = new HashMap<>();
    for (int i = 0; i < patterns.length; i++) {
      char p = patterns[i];
      String word = words[i];
      if (patternMap.containsKey(p)) {
        if (!patternMap.get(p).equals(word)) {
          return false;
        }
      } else {
        if (patternMap.containsValue(word)) {
          return false;
        }
        patternMap.put(p, word);
      }
    }

    return true;
  }
}
