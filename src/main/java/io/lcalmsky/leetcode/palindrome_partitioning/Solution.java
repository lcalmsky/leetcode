package io.lcalmsky.leetcode.palindrome_partitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<List<String>> partition(String s) {
    List<List<String>> lists = new ArrayList<>();
    if (s == null || s.length() == 0) {
      return lists;
    }
    List<String> partitions = new ArrayList<>();
    addPalindrome(s, 0, partitions, lists);
    return lists;
  }

  private void addPalindrome(String s, int start, List<String> partitions,
      List<List<String>> lists) {
    if (start == s.length()) {
      lists.add(new ArrayList<>(partitions));
      return;
    }
    for (int i = start + 1; i <= s.length(); i++) {
      String str = s.substring(start, i);
      if (isPalindrome(str)) {
        partitions.add(str);
        addPalindrome(s, i, partitions, lists);
        partitions.remove(partitions.size() - 1);
      }
    }
  }

  private boolean isPalindrome(String str) {
    int left = 0;
    int right = str.length() - 1;
    while (left < right) {
      if (str.charAt(left++) != str.charAt(right--)) {
        return false;
      }
    }
    return true;
  }
}