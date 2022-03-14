package io.lcalmsky.leetcode.simplify_path;

import java.util.Stack;

public class Solution {

  public String simplifyPath(String path) {
    String[] names = path.split("/");
    Stack<String> stack = new Stack<>();
    for (String name : names) {
      if ("..".equals(name)) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else if (!".".equals(name) && !name.isEmpty()) {
        stack.push(name);
      }
    }
    if (stack.isEmpty()) {
      return "/";
    }
    StringBuilder result = new StringBuilder();
    while (!stack.isEmpty()) {
      result.insert(0, "/" + stack.pop());
    }
    return result.toString();
  }
}
