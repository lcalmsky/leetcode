package io.lcalmsky.leetcode.is_subsequence;

public class Solution {

  public boolean isSubsequence(String s, String t) {
    if (s == null || s.length() == 0) {
      return true;
    }
    int sIndex = 0, tIndex = 0;
    while (sIndex < s.length() && tIndex < t.length()) {
      if (s.charAt(sIndex) == t.charAt(tIndex)) {
        sIndex++;
      }
      tIndex++;
      if (sIndex == s.length()) {
        return true;
      }
    }
    return false;
  }
}

class Solution2 extends Solution {

  @Override
  public boolean isSubsequence(String s, String t) {
    for (char ch : s.toCharArray()) {
      int find = t.indexOf(ch);
      if (find == -1) {
        return false;
      }
      t = t.substring(find + 1);
    }
    return true;
  }
}

class Solution3 extends Solution {

  @Override
  public boolean isSubsequence(String s, String t) {
    int start = 0;
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      while (start < t.length()) {
        if (ch == t.charAt(start)) {
          count++;
          start++;
          break;
        }
        start++;
      }
    }
    return count == s.length();
  }
}