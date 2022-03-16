package io.lcalmsky.leetcode.validate_stack_sequences;

public class Solution {

  public boolean validateStackSequences(int[] pushed, int[] popped) {
    int i = 0, j = 0;
    for (int val : pushed) {
      pushed[i++] = val;
      while (j < popped.length && i > 0 && pushed[i - 1] == popped[j]) {
        i--;
        j++;
      }
    }
    return i == 0;
  }
}
