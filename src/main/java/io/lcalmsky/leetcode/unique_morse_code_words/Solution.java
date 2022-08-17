package io.lcalmsky.leetcode.unique_morse_code_words;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  private static final String[] MORSE_CODES = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
      "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
      "..-", "...-", ".--", "-..-", "-.--", "--.."};

  public int uniqueMorseRepresentations(String[] words) {
    Set<String> uniqueMorseRepresentations = new HashSet<>();
    for (String word : words) {
      StringBuilder stringBuilder = new StringBuilder();
      for (char c : word.toCharArray()) {
        stringBuilder.append(MORSE_CODES[c - 'a']);
      }
      uniqueMorseRepresentations.add(stringBuilder.toString());
    }
    return uniqueMorseRepresentations.size();
  }
}
