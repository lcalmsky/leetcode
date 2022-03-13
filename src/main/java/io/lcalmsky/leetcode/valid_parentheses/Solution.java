package io.lcalmsky.leetcode.valid_parentheses;

public class Solution {

  public boolean isValid(String s) {
    char[] ch = new char[s.length()];
    int index = -1;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '{' || c == '[') {
        ch[++index] = c;
      } else {
        if (index < 0) {
          return false;
        }
        if (c == ')' && ch[index] != '(') {
          return false;
        }
        if (c == '}' && ch[index] != '{') {
          return false;
        }
        if (c == ']' && ch[index] != '[') {
          return false;
        }
        index--;
      }
    }
    return index < 0;
  }
}
