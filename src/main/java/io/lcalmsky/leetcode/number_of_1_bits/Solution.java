package io.lcalmsky.leetcode.number_of_1_bits;

public class Solution {

  public int hammingWeight(int n) {
    int num = 0;

    for (int i = 0; i < 32; i++) {
      if ((n & 1) == 1) {
        num++;
      }
      n = n >> 1;
    }

    return num;
  }
}
