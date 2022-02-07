package io.lcalmsky.leetcode.find_the_difference;

public class Solution {

  public char findTheDifference(String s, String t) {
    int[] alphabets = new int[26];
    for (char c : s.toCharArray()) {
      alphabets[c - 'a']++;
    }
    for (char c : t.toCharArray()) {
      alphabets[c - 'a']--;
      if (alphabets[c - 'a'] < 0) {
        return c;
      }
    }
    throw new IllegalStateException();
  }
}
