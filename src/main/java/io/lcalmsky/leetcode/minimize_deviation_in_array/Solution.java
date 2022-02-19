package io.lcalmsky.leetcode.minimize_deviation_in_array;

import java.util.TreeSet;

public class Solution {

  public int minimumDeviation(int[] nums) {
    TreeSet<Integer> treeSet = new TreeSet<>();
    for (int num : nums) {
      if (num % 2 == 1) {
        treeSet.add(num * 2);
      } else {
        treeSet.add(num);
      }
    }
    int minDeviation = treeSet.last() - treeSet.first();
    while (treeSet.last() % 2 == 0) {
      treeSet.add(treeSet.last() / 2);
      treeSet.remove(treeSet.last());
      minDeviation = Math.min(minDeviation, treeSet.last() - treeSet.first());
    }
    return minDeviation;
  }
}
