package io.lcalmsky.leetcode.ransom_note;

public class Solution {

  public boolean canConstruct(String ransomNote, String magazine) {
    int[] alphabets = new int[26];
    for (char c : magazine.toCharArray()) {
      alphabets[c - 'a']++;
    }
    for (char c : ransomNote.toCharArray()) {
      if (--alphabets[c - 'a'] < 0) {
        return false;
      }
    }
    return true;
  }
}
