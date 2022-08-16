package io.lcalmsky.leetcode.first_unique_character_in_a_string;

public class Solution {

  public int firstUniqChar(String s) {
    int[] alphabets = new int[26];
    for (int i = 0; i < s.length(); i++) {
      alphabets[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < s.length(); i++) {
      if (alphabets[s.charAt(i) - 'a'] == 1) {
        return i;
      }
    }
    return -1;
  }
}
