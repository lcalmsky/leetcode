package io.lcalmsky.leetcode.jump_game_iv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

  public int minJumps(int[] arr) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    int length = arr.length;
    for (int i = 0; i < length; i++) {
      map.putIfAbsent(arr[i], new ArrayList<>());
      map.get(arr[i]).add(i);
    }
    boolean[] visited = new boolean[length];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);
    int steps = 0;
    while (!queue.isEmpty()) {
      int remain = queue.size();
      while (remain-- > 0) {
        int polled = queue.poll();
        if (polled == length - 1) {
          return steps;
        }
        int previous = polled - 1;
        if (previous >= 0 && !visited[previous]) {
          visited[previous] = true;
          queue.add(previous);
        }
        int next = polled + 1;
        if (next < length && !visited[next]) {
          visited[next] = true;
          queue.add(next);
        }
        if (set.contains(arr[polled])) {
          continue;
        }
        set.add(arr[polled]);
        for (Integer index : map.get(arr[polled])) {
          if (!visited[index]) {
            visited[index] = true;
            queue.add(index);
          }
        }
      }
      steps++;
    }
    return steps;
  }
}
