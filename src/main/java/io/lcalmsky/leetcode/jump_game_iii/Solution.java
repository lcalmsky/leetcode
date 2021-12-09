package io.lcalmsky.leetcode.jump_game_iii;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

  public boolean canReach(int[] arr, int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    boolean[] visited = new boolean[arr.length];
    visited[start] = true;
    while (!queue.isEmpty()) {
      int current = queue.poll();
      if (arr[current] == 0) {
        return true;
      }
      visited[current] = true;
      int right = current + arr[current], left = current - arr[current];
      if (right < arr.length && !visited[right]) {
        queue.offer(right);
      }
      if (left >= 0 && !visited[left]) {
        queue.offer(left);
      }
    }
    return false;
  }
}

class AnotherSolution extends Solution {

  public boolean canReach(int[] arr, int start) {
    if (arr[start] == 0) {
      return true;
    }
    if (arr[start] < 0) {
      return false;
    }
    arr[start] = -arr[start];
    int right = start - arr[start];
    if (right < arr.length && canReach(arr, right)) {
      return true;
    }
    int left = start + arr[start];
    return left >= 0 && canReach(arr, left);
  }
}
