package io.lcalmsky.leetcode.decode_string;

import java.util.Stack;

/**
 * <pre>
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * </pre>
 */
public class Solution {

  public String decodeString(String s) {
    StringBuilder result = new StringBuilder();
    Stack<Integer> countStack = new Stack<>();
    Stack<String> resultStack = new Stack<>();
    int index = 0;
    while (index < s.length()) {
      if (Character.isDigit(s.charAt(index))) {
        int count = 0;
        while (Character.isDigit(s.charAt(index))) {
          count = 10 * count + (s.charAt(index) - '0');
          index++;
        }
        countStack.push(count);
      } else if (s.charAt(index) == '[') {
        resultStack.push(result.toString());
        result = new StringBuilder();
        index++;
      } else if (s.charAt(index) == ']') {
        StringBuilder temp = new StringBuilder(resultStack.pop());
        int repeatTimes = countStack.pop();
        temp.append(result.toString().repeat(Math.max(0, repeatTimes)));
        result = new StringBuilder(temp.toString());
        index++;
      } else {
        result.append(s.charAt(index));
        index++;
      }
    }
    return result.toString();
  }
}
