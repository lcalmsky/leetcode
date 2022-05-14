package io.lcalmsky.leetcode.network_delay_time;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

  public int networkDelayTime(int[][] times, int n, int k) {
    Map<Integer, List<int[]>> map = new HashMap<>();
    for (int[] time : times) {
      map.putIfAbsent(time[0], new ArrayList<>());
      map.get(time[0]).add(new int[]{time[1], time[2]});
    }
    PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    queue.offer(new int[]{k, 0});
    boolean[] visited = new boolean[n + 1];
    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      if (visited[current[0]]) {
        continue;
      }
      visited[current[0]] = true;
      if (--n == 0) {
        return current[1];
      }
      if (map.containsKey(current[0])) {
        for (int[] next : map.get(current[0])) {
          queue.offer(new int[]{next[0], current[1] + next[1]});
        }
      }
    }
    return -1;
  }
}