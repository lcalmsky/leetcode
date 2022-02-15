package io.lcalmsky.leetcode.single_number;

public class Solution {

  public int singleNumber(int[] nums) {
    int x = 0;
    for (int num : nums) {
      x ^= num;
      System.out.println(x);
    }
    return x;
  }
}
