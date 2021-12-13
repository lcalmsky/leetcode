package io.lcalmsky.leetcode.consecutive_characters;

public class Solution {

  public int maxPower(String s) {
    char[] chars = s.toCharArray();
    char c = chars[0];
    int cnt = 1;
    int max = 0;
    for (int i = 1; i < chars.length; i++) {
      if (c == chars[i]) {
        cnt++;
        max = Math.max(max, cnt);
      } else {
        c = chars[i];
        cnt = 1;
      }
    }
    return Math.max(max, cnt);
  }
}
