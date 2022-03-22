package io.lcalmsky.leetcode.smallest_string_with_a_given_numeric_value;

import java.util.Arrays;

public class Solution {

  public String getSmallestString(int n, int k) {
    char[] array = new char[n];
    Arrays.fill(array, 'a');
    k -= n;
    for (int i = n - 1; i >= 0 && k > 0; i--) {
      int min = Math.min(25, k);
      array[i] += min;
      k -= min;
    }
    return String.valueOf(array);
  }
}
