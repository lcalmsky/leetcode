package io.lcalmsky.leetcode.counting_bits;

public class Solution {

  public int[] countBits(int num) {
    int[] result = new int[num + 1];
    int p = 1;
    int pow = 1;
    for (int i = 1; i <= num; i++) {
      if (i == pow) {
        result[i] = 1;
        pow *= 2;
        p = 1;
      } else {
        result[i] = result[p++] + 1;
      }
    }
    return result;
  }
}
