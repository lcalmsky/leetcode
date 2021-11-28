package io.lcalmsky.leetcode.all_paths_from_source_to_target;

import java.util.LinkedList;
import java.util.List;

public class Solution {

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> result = new LinkedList<>();
    List<Integer> path = new LinkedList<>();
    path.add(0);
    dfs(graph, 0, path, result);
    return result;
  }

  private void dfs(int[][] graph, int index, List<Integer> path, List<List<Integer>> rst) {
    if (index == graph.length - 1) {
      rst.add(new LinkedList<>(path));
      return;
    }
    for (int neighbor : graph[index]) {
      path.add(neighbor);
      dfs(graph, neighbor, path, rst);
      path.remove(path.size() - 1);
    }
  }
}
