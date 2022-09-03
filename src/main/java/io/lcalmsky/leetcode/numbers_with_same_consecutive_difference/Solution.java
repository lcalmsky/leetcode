package io.lcalmsky.leetcode.numbers_with_same_consecutive_difference;

import java.util.ArrayList;
import java.util.List;

class Solution {

  public int[] numsSameConsecDiff(int N, int K) {
    if (N == 1) {
      return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    }
    List<Integer> results = new ArrayList<>();
    for (int num = 1; num < 10; num++) {
      dfs(N - 1, num, K, results);
    }
    return results.stream().mapToInt(i -> i).toArray();
  }

  private void dfs(int N, int num, int K, List<Integer> results) {
    if (N == 0) {
      results.add(num);
      return;
    }
    List<Integer> nextDigits = new ArrayList<>();
    int tailDigit = num % 10;
    nextDigits.add(tailDigit + K);
    if (K != 0) {
      nextDigits.add(tailDigit - K);
    }
    for (int nextDigit : nextDigits) {
      if (0 <= nextDigit && nextDigit < 10) {
        int newNum = num * 10 + nextDigit;
        dfs(N - 1, newNum, K, results);
      }
    }
  }
}

class Solution2 {

  public int[] numsSameConsecDiff(int N, int K) {
    if (N == 1) {
      return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    }
    List<Integer> queue = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    for (int level = 1; level < N; level++) {
      List<Integer> nextQueue = new ArrayList<>();
      for (Integer num : queue) {
        int tailDigit = num % 10;
        ArrayList<Integer> nextDigits = new ArrayList<>();
        nextDigits.add(tailDigit + K);
        if (K != 0) {
          nextDigits.add(tailDigit - K);
        }
        for (Integer nextDigit : nextDigits) {
          if (0 <= nextDigit && nextDigit < 10) {
            Integer newNum = num * 10 + nextDigit;
            nextQueue.add(newNum);
          }
        }
      }
      queue = nextQueue;
    }
    return queue.stream().mapToInt(i -> i).toArray();
  }
}