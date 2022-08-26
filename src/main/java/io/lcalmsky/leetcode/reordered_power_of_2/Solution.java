package io.lcalmsky.leetcode.reordered_power_of_2;

import java.util.Arrays;

public class Solution {

  public boolean reorderedPowerOf2(int n) {
    String sortedInteger = sort(n);
    for (int i = 0; i < 31; ++i) {
      String sorted = sort(1 << i);
      if (sortedInteger.equals(sorted)) {
        return true;
      }
      if (sorted.length() > sortedInteger.length()) {
        break;
      }
    }
    return false;
  }

  private String sort(int n) {
    char[] num = String.valueOf(n).toCharArray();
    Arrays.sort(num);
    return String.valueOf(num);
  }
}
