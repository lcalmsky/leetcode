package io.lcalmsky.leetcode.course_schedule_ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    int[] subsequentCourses = new int[numCourses];
    for (int[] prerequisite : prerequisites) {
      subsequentCourses[prerequisite[0]]++;
      map.computeIfAbsent(prerequisite[1], k -> new HashSet<>()).add(prerequisite[0]);
    }
    System.out.println("map = " + map);
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (subsequentCourses[i] == 0) {
        queue.offer(i);
      }
    }
    System.out.println("queue = " + queue);
    List<Integer> result = new ArrayList<>();
    while (!queue.isEmpty()) {
      int course = queue.poll();
      result.add(course);
      if (!map.containsKey(course)) {
        continue;
      }
      for (Integer next : map.get(course)) {
        if (--subsequentCourses[next] == 0) {
          queue.offer(next);
        }
      }
    }
    if (result.size() != numCourses) {
      return new int[0];
    }
    int[] answer = new int[result.size()];
    for (int i = 0; i < answer.length; i++) {
      answer[i] = result.get(i);
    }
    return answer;
  }
}
