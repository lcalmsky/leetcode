package io.lcalmsky.leetcode.complement_of_base_10_integer;

public class Solution {

  public int bitwiseComplement(int n) {
    if (n == 0) {
      return 1;
    }
    int scope = 1;
    while (scope <= n) {
      scope *= 2;
    }
    return scope - n - 1;
  }
}
