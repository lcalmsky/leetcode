package io.lcalmsky.leetcode.combination_sum_iii;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    dfs(result, list, k, 1, n);
    return result;
  }

  private void dfs(List<List<Integer>> result, List<Integer> list, int k, int start, int sum) {
    if (sum < 0) {
      return;
    }
    if (sum == 0 && list.size() == k) {
      result.add(new ArrayList<>(list));
      return;
    }
    for (int i = start; i <= 9; i++) {
      list.add(i);
      dfs(result, list, k, i + 1, sum - i);
      list.remove(list.size() - 1);
    }
  }
}
