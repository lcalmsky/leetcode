package io.lcalmsky.leetcode.power_of_tree;

public class Solution {

  public boolean isPowerOfThree(int n) {
    if (n == 0) {
      return false;
    }
    int r = 0;

    while (n > 1) {
      r = n % 3;
      if (r != 0) {
        return false;
      }
      n = n / 3;
    }
    return n == 1;
  }
}
