package io.lcalmsky.leetcode.arithmetic_slices;

public class Solution {

  public int numberOfArithmeticSlices(int[] A) {
    int current = 0, sum = 0;
    for (int i = 2; i < A.length; i++) {
      if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
        current += 1;
        sum += current;
      } else {
        current = 0;
      }
    }
    return sum;
  }
}
