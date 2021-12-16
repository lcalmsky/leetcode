package io.lcalmsky.leetcode.minimum_height_trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {

  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n == 0) {
      return Collections.emptyList();
    }
    if (n == 1) {
      return Collections.singletonList(0);
    }
    List<Set<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new HashSet<>());
    }
    for (int[] edge : edges) {
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }
    Deque<Integer> leaves = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (graph.get(i).size() == 1) {
        leaves.offer(i);
      }
    }
    while (n > 2) {
      n = n - leaves.size();
      Deque<Integer> newLeaves = new LinkedList<>();
      for (int leave : leaves) {
        int neighbor = graph.get(leave).iterator().next();
        graph.get(neighbor).remove(leave);
        if (graph.get(neighbor).size() == 1) {
          newLeaves.add(neighbor);
        }
      }
      leaves = newLeaves;
    }
    return new ArrayList<>(leaves);
  }
}